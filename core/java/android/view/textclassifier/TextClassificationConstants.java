/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.view.textclassifier;

import android.annotation.Nullable;
import android.content.Context;
import android.provider.DeviceConfig;

import com.android.internal.annotations.VisibleForTesting;
import com.android.internal.util.IndentingPrintWriter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TextClassifier specific settings.
 *
 * <p>Currently, this class does not guarantee co-diverted flags are updated atomically.
 *
 * <pre>
 * adb shell cmd device_config put textclassifier system_textclassifier_enabled true
 * </pre>
 *
 * @see android.provider.DeviceConfig#NAMESPACE_TEXTCLASSIFIER
 * @hide
 */
// TODO: Rename to TextClassifierSettings.
public final class TextClassificationConstants {
    private static final String DELIMITER = ":";

    /**
     * Whether the smart linkify feature is enabled.
     */
    private static final String SMART_LINKIFY_ENABLED = "smart_linkify_enabled";
    /**
     * Whether SystemTextClassifier is enabled.
     */
    static final String SYSTEM_TEXT_CLASSIFIER_ENABLED = "system_textclassifier_enabled";
    /**
     * Whether TextClassifierImpl is enabled.
     */
    @VisibleForTesting
    static final String LOCAL_TEXT_CLASSIFIER_ENABLED = "local_textclassifier_enabled";
    /**
     * Enable smart selection without a visible UI changes.
     */
    private static final String MODEL_DARK_LAUNCH_ENABLED = "model_dark_launch_enabled";

    /**
     * Whether the smart selection feature is enabled.
     */
    private static final String SMART_SELECTION_ENABLED = "smart_selection_enabled";
    /**
     * Whether the smart text share feature is enabled.
     */
    private static final String SMART_TEXT_SHARE_ENABLED = "smart_text_share_enabled";
    /**
     * Whether animation for smart selection is enabled.
     */
    private static final String SMART_SELECT_ANIMATION_ENABLED =
            "smart_select_animation_enabled";
    /**
     * Max length of text that suggestSelection can accept.
     */
    @VisibleForTesting
    static final String SUGGEST_SELECTION_MAX_RANGE_LENGTH =
            "suggest_selection_max_range_length";
    /**
     * Max length of text that classifyText can accept.
     */
    private static final String CLASSIFY_TEXT_MAX_RANGE_LENGTH = "classify_text_max_range_length";
    /**
     * Max length of text that generateLinks can accept.
     */
    private static final String GENERATE_LINKS_MAX_TEXT_LENGTH = "generate_links_max_text_length";
    /**
     * Sampling rate for generateLinks logging.
     */
    private static final String GENERATE_LINKS_LOG_SAMPLE_RATE =
            "generate_links_log_sample_rate";
    /**
     * A colon(:) separated string that specifies the default entities types for
     * generateLinks when hint is not given.
     */
    @VisibleForTesting
    static final String ENTITY_LIST_DEFAULT = "entity_list_default";
    /**
     * A colon(:) separated string that specifies the default entities types for
     * generateLinks when the text is in a not editable UI widget.
     */
    private static final String ENTITY_LIST_NOT_EDITABLE = "entity_list_not_editable";
    /**
     * A colon(:) separated string that specifies the default entities types for
     * generateLinks when the text is in an editable UI widget.
     */
    private static final String ENTITY_LIST_EDITABLE = "entity_list_editable";
    /**
     * A colon(:) separated string that specifies the default action types for
     * suggestConversationActions when the suggestions are used in an app.
     */
    private static final String IN_APP_CONVERSATION_ACTION_TYPES_DEFAULT =
            "in_app_conversation_action_types_default";
    /**
     * A colon(:) separated string that specifies the default action types for
     * suggestConversationActions when the suggestions are used in a notification.
     */
    private static final String NOTIFICATION_CONVERSATION_ACTION_TYPES_DEFAULT =
            "notification_conversation_action_types_default";
    /**
     * Threshold to accept a suggested language from LangID model.
     */
    @VisibleForTesting
    static final String LANG_ID_THRESHOLD_OVERRIDE = "lang_id_threshold_override";
    /**
     * Whether to enable {@link android.view.textclassifier.TemplateIntentFactory}.
     */
    private static final String TEMPLATE_INTENT_FACTORY_ENABLED = "template_intent_factory_enabled";
    /**
     * Whether to enable "translate" action in classifyText.
     */
    private static final String TRANSLATE_IN_CLASSIFICATION_ENABLED =
            "translate_in_classification_enabled";
    /**
     * Whether to detect the languages of the text in request by using langId for the native
     * model.
     */
    private static final String DETECT_LANGUAGES_FROM_TEXT_ENABLED =
            "detect_languages_from_text_enabled";
    /**
     * A colon(:) separated string that specifies the configuration to use when including
     * surrounding context text in language detection queries.
     * <p>
     * Format= minimumTextSize<int>:penalizeRatio<float>:textScoreRatio<float>
     * <p>
     * e.g. 20:1.0:0.4
     * <p>
     * Accept all text lengths with minimumTextSize=0
     * <p>
     * Reject all text less than minimumTextSize with penalizeRatio=0
     * @see {@code TextClassifierImpl#detectLanguages(String, int, int)} for reference.
     */
    @VisibleForTesting
    static final String LANG_ID_CONTEXT_SETTINGS = "lang_id_context_settings";

    /**
     * The TextClassifierService which would like to use. Example of setting the package:
     * <pre>
     * adb shell cmd device_config put textclassifier textclassifier_service_package_override \
     *      com.android.textclassifier
     * </pre>
     */
    @VisibleForTesting
    static final String TEXT_CLASSIFIER_SERVICE_PACKAGE_OVERRIDE =
            "textclassifier_service_package_override";

    /**
     * Whether to use the default system text classifier as the default text classifier
     * implementation. The local text classifier is used if it is {@code false}.
     *
     * @see android.service.textclassifier.TextClassifierService#getDefaultTextClassifierImplementation(Context)
     */
    // TODO: Once the system health experiment is done, remove this together with local TC.
    private static final String USE_DEFAULT_SYSTEM_TEXT_CLASSIFIER_AS_DEFAULT_IMPL =
            "use_default_system_text_classifier_as_default_impl";

    private static final String DEFAULT_TEXT_CLASSIFIER_SERVICE_PACKAGE_OVERRIDE = null;
    private static final boolean LOCAL_TEXT_CLASSIFIER_ENABLED_DEFAULT = true;
    private static final boolean SYSTEM_TEXT_CLASSIFIER_ENABLED_DEFAULT = true;
    private static final boolean MODEL_DARK_LAUNCH_ENABLED_DEFAULT = false;
    private static final boolean SMART_SELECTION_ENABLED_DEFAULT = true;
    private static final boolean SMART_TEXT_SHARE_ENABLED_DEFAULT = true;
    private static final boolean SMART_LINKIFY_ENABLED_DEFAULT = true;
    private static final boolean SMART_SELECT_ANIMATION_ENABLED_DEFAULT = true;
    private static final int SUGGEST_SELECTION_MAX_RANGE_LENGTH_DEFAULT = 10 * 1000;
    private static final int CLASSIFY_TEXT_MAX_RANGE_LENGTH_DEFAULT = 10 * 1000;
    private static final int GENERATE_LINKS_MAX_TEXT_LENGTH_DEFAULT = 100 * 1000;
    private static final int GENERATE_LINKS_LOG_SAMPLE_RATE_DEFAULT = 100;
    private static final List<String> ENTITY_LIST_DEFAULT_VALUE = Arrays.asList(
            TextClassifier.TYPE_ADDRESS,
            TextClassifier.TYPE_EMAIL,
            TextClassifier.TYPE_PHONE,
            TextClassifier.TYPE_URL,
            TextClassifier.TYPE_DATE,
            TextClassifier.TYPE_DATE_TIME,
            TextClassifier.TYPE_FLIGHT_NUMBER);
    private static final List<String> CONVERSATION_ACTIONS_TYPES_DEFAULT_VALUES = Arrays.asList(
            ConversationAction.TYPE_TEXT_REPLY,
            ConversationAction.TYPE_CREATE_REMINDER,
            ConversationAction.TYPE_CALL_PHONE,
            ConversationAction.TYPE_OPEN_URL,
            ConversationAction.TYPE_SEND_EMAIL,
            ConversationAction.TYPE_SEND_SMS,
            ConversationAction.TYPE_TRACK_FLIGHT,
            ConversationAction.TYPE_VIEW_CALENDAR,
            ConversationAction.TYPE_VIEW_MAP,
            ConversationAction.TYPE_ADD_CONTACT,
            ConversationAction.TYPE_COPY);
    /**
     * < 0  : Not set. Use value from LangId model.
     * 0 - 1: Override value in LangId model.
     *
     * @see EntityConfidence
     */
    private static final float LANG_ID_THRESHOLD_OVERRIDE_DEFAULT = -1f;
    private static final boolean TEMPLATE_INTENT_FACTORY_ENABLED_DEFAULT = true;
    private static final boolean TRANSLATE_IN_CLASSIFICATION_ENABLED_DEFAULT = true;
    private static final boolean DETECT_LANGUAGES_FROM_TEXT_ENABLED_DEFAULT = true;
    private static final float[] LANG_ID_CONTEXT_SETTINGS_DEFAULT = new float[]{20f, 1.0f, 0.4f};
    private static final boolean USE_DEFAULT_SYSTEM_TEXT_CLASSIFIER_AS_DEFAULT_IMPL_DEFAULT = true;

    @Nullable
    public String getTextClassifierServicePackageOverride() {
        return DeviceConfig.getString(DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                TEXT_CLASSIFIER_SERVICE_PACKAGE_OVERRIDE,
                DEFAULT_TEXT_CLASSIFIER_SERVICE_PACKAGE_OVERRIDE);
    }

    public boolean isLocalTextClassifierEnabled() {
        return DeviceConfig.getBoolean(DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                LOCAL_TEXT_CLASSIFIER_ENABLED, LOCAL_TEXT_CLASSIFIER_ENABLED_DEFAULT);
    }

    public boolean isSystemTextClassifierEnabled() {
        return DeviceConfig.getBoolean(DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                SYSTEM_TEXT_CLASSIFIER_ENABLED,
                SYSTEM_TEXT_CLASSIFIER_ENABLED_DEFAULT);
    }

    public boolean isModelDarkLaunchEnabled() {
        return DeviceConfig.getBoolean(DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                MODEL_DARK_LAUNCH_ENABLED, MODEL_DARK_LAUNCH_ENABLED_DEFAULT);
    }

    public boolean isSmartSelectionEnabled() {
        return DeviceConfig.getBoolean(DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                SMART_SELECTION_ENABLED, SMART_SELECTION_ENABLED_DEFAULT);
    }

    public boolean isSmartTextShareEnabled() {
        return DeviceConfig.getBoolean(DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                SMART_TEXT_SHARE_ENABLED, SMART_TEXT_SHARE_ENABLED_DEFAULT);
    }

    public boolean isSmartLinkifyEnabled() {
        return DeviceConfig.getBoolean(DeviceConfig.NAMESPACE_TEXTCLASSIFIER, SMART_LINKIFY_ENABLED,
                SMART_LINKIFY_ENABLED_DEFAULT);
    }

    public boolean isSmartSelectionAnimationEnabled() {
        return DeviceConfig.getBoolean(DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                SMART_SELECT_ANIMATION_ENABLED, SMART_SELECT_ANIMATION_ENABLED_DEFAULT);
    }

    public int getSuggestSelectionMaxRangeLength() {
        return DeviceConfig.getInt(DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                SUGGEST_SELECTION_MAX_RANGE_LENGTH, SUGGEST_SELECTION_MAX_RANGE_LENGTH_DEFAULT);
    }

    public int getClassifyTextMaxRangeLength() {
        return DeviceConfig.getInt(DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                CLASSIFY_TEXT_MAX_RANGE_LENGTH, CLASSIFY_TEXT_MAX_RANGE_LENGTH_DEFAULT);
    }

    public int getGenerateLinksMaxTextLength() {
        return DeviceConfig.getInt(DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                GENERATE_LINKS_MAX_TEXT_LENGTH, GENERATE_LINKS_MAX_TEXT_LENGTH_DEFAULT);
    }

    public int getGenerateLinksLogSampleRate() {
        return DeviceConfig.getInt(DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                GENERATE_LINKS_LOG_SAMPLE_RATE, GENERATE_LINKS_LOG_SAMPLE_RATE_DEFAULT);
    }

    public List<String> getEntityListDefault() {
        return getDeviceConfigStringList(ENTITY_LIST_DEFAULT, ENTITY_LIST_DEFAULT_VALUE);
    }

    public List<String> getEntityListNotEditable() {
        return getDeviceConfigStringList(ENTITY_LIST_NOT_EDITABLE, ENTITY_LIST_DEFAULT_VALUE);
    }

    public List<String> getEntityListEditable() {
        return getDeviceConfigStringList(ENTITY_LIST_EDITABLE, ENTITY_LIST_DEFAULT_VALUE);
    }

    public List<String> getInAppConversationActionTypes() {
        return getDeviceConfigStringList(
                IN_APP_CONVERSATION_ACTION_TYPES_DEFAULT,
                CONVERSATION_ACTIONS_TYPES_DEFAULT_VALUES);
    }

    public List<String> getNotificationConversationActionTypes() {
        return getDeviceConfigStringList(
                NOTIFICATION_CONVERSATION_ACTION_TYPES_DEFAULT,
                CONVERSATION_ACTIONS_TYPES_DEFAULT_VALUES);
    }

    public float getLangIdThresholdOverride() {
        return DeviceConfig.getFloat(
                DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                LANG_ID_THRESHOLD_OVERRIDE,
                LANG_ID_THRESHOLD_OVERRIDE_DEFAULT);
    }

    public boolean isTemplateIntentFactoryEnabled() {
        return DeviceConfig.getBoolean(
                DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                TEMPLATE_INTENT_FACTORY_ENABLED,
                TEMPLATE_INTENT_FACTORY_ENABLED_DEFAULT);
    }

    public boolean isTranslateInClassificationEnabled() {
        return DeviceConfig.getBoolean(
                DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                TRANSLATE_IN_CLASSIFICATION_ENABLED,
                TRANSLATE_IN_CLASSIFICATION_ENABLED_DEFAULT);
    }

    public boolean isDetectLanguagesFromTextEnabled() {
        return DeviceConfig.getBoolean(
                DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                DETECT_LANGUAGES_FROM_TEXT_ENABLED,
                DETECT_LANGUAGES_FROM_TEXT_ENABLED_DEFAULT);
    }

    public float[] getLangIdContextSettings() {
        return getDeviceConfigFloatArray(
                LANG_ID_CONTEXT_SETTINGS, LANG_ID_CONTEXT_SETTINGS_DEFAULT);
    }

    public boolean getUseDefaultTextClassifierAsDefaultImplementation() {
        return DeviceConfig.getBoolean(
                DeviceConfig.NAMESPACE_TEXTCLASSIFIER,
                USE_DEFAULT_SYSTEM_TEXT_CLASSIFIER_AS_DEFAULT_IMPL,
                USE_DEFAULT_SYSTEM_TEXT_CLASSIFIER_AS_DEFAULT_IMPL_DEFAULT);
    }

    void dump(IndentingPrintWriter pw) {
        pw.println("TextClassificationConstants:");
        pw.increaseIndent();
        pw.printPair("classify_text_max_range_length", getClassifyTextMaxRangeLength())
                .println();
        pw.printPair("detect_languages_from_text_enabled", isDetectLanguagesFromTextEnabled())
                .println();
        pw.printPair("entity_list_default", getEntityListDefault())
                .println();
        pw.printPair("entity_list_editable", getEntityListEditable())
                .println();
        pw.printPair("entity_list_not_editable", getEntityListNotEditable())
                .println();
        pw.printPair("generate_links_log_sample_rate", getGenerateLinksLogSampleRate())
                .println();
        pw.printPair("generate_links_max_text_length", getGenerateLinksMaxTextLength())
                .println();
        pw.printPair("in_app_conversation_action_types_default", getInAppConversationActionTypes())
                .println();
        pw.printPair("lang_id_context_settings", Arrays.toString(getLangIdContextSettings()))
                .println();
        pw.printPair("lang_id_threshold_override", getLangIdThresholdOverride())
                .println();
        pw.printPair("local_textclassifier_enabled", isLocalTextClassifierEnabled())
                .println();
        pw.printPair("model_dark_launch_enabled", isModelDarkLaunchEnabled())
                .println();
        pw.printPair("notification_conversation_action_types_default",
                getNotificationConversationActionTypes()).println();
        pw.printPair("smart_linkify_enabled", isSmartLinkifyEnabled())
                .println();
        pw.printPair("smart_select_animation_enabled", isSmartSelectionAnimationEnabled())
                .println();
        pw.printPair("smart_selection_enabled", isSmartSelectionEnabled())
                .println();
        pw.printPair("smart_text_share_enabled", isSmartTextShareEnabled())
                .println();
        pw.printPair("suggest_selection_max_range_length", getSuggestSelectionMaxRangeLength())
                .println();
        pw.printPair("system_textclassifier_enabled", isSystemTextClassifierEnabled())
                .println();
        pw.printPair("template_intent_factory_enabled", isTemplateIntentFactoryEnabled())
                .println();
        pw.printPair("translate_in_classification_enabled", isTranslateInClassificationEnabled())
                .println();
        pw.printPair("textclassifier_service_package_override",
                getTextClassifierServicePackageOverride()).println();
        pw.printPair("use_default_system_text_classifier_as_default_impl",
                getUseDefaultTextClassifierAsDefaultImplementation()).println();
        pw.decreaseIndent();
    }

    private static List<String> getDeviceConfigStringList(String key, List<String> defaultValue) {
        return parse(
                DeviceConfig.getString(DeviceConfig.NAMESPACE_TEXTCLASSIFIER, key, null),
                defaultValue);
    }

    private static float[] getDeviceConfigFloatArray(String key, float[] defaultValue) {
        return parse(
                DeviceConfig.getString(DeviceConfig.NAMESPACE_TEXTCLASSIFIER, key, null),
                defaultValue);
    }

    private static List<String> parse(@Nullable String listStr, List<String> defaultValue) {
        if (listStr != null) {
            return Collections.unmodifiableList(Arrays.asList(listStr.split(DELIMITER)));
        }
        return defaultValue;
    }

    private static float[] parse(@Nullable String arrayStr, float[] defaultValue) {
        if (arrayStr != null) {
            final String[] split = arrayStr.split(DELIMITER);
            if (split.length != defaultValue.length) {
                return defaultValue;
            }
            final float[] result = new float[split.length];
            for (int i = 0; i < split.length; i++) {
                try {
                    result[i] = Float.parseFloat(split[i]);
                } catch (NumberFormatException e) {
                    return defaultValue;
                }
            }
            return result;
        } else {
            return defaultValue;
        }
    }
}