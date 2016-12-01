package jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_支給申請書登録画面タイトルを表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kaigogassan_ShikyushinseishoTorokugamenTitle {

    /**
     * コード:1 名称:高額合算支給申請書登録・新規申請 略称:高額合算支給申請書登録・新規
     */
    高額合算支給申請書登録_新規申請("1", "高額合算支給申請書登録・新規申請", "高額合算支給申請書登録・新規"),
    /**
     * コード:2 名称:高額合算支給申請書登録・変更申請 略称:高額合算支給申請書登録・変更
     */
    高額合算支給申請書登録_変更申請("2", "高額合算　支給申請書登録・変更", "高額合算支給申請書登録・変更"),
    /**
     * コード:3 名称:高額合算支給申請書登録・取下げ申請 略称:高額合算支給申請書登録・取下げ
     */
    高額合算支給申請書登録_取下げ申請("3", "高額合算　支給申請書登録・取下げ", "高額合算支給申請書登録・取下げ"),
    /**
     * コード:4 名称:高額合算支給申請書訂正 略称:高額合算支給申請書・訂正
     */
    高額合算支給申請書訂正("4", "高額合算　支給申請書・訂正", "高額合算支給申請書訂正"),
    /**
     * コード:5 名称:高額合算支給申請書（写）登録・新規申請 略称:高額合算支給申請書（写）・新規
     */
    高額合算支給申請書_写_登録_新規申請("5", "高額合算　支給申請書（写）・新規", "高額合算支給申請書（写）・新規"),
    /**
     * コード:6 名称:高額合算支給申請書（写）登録・変更申請 略称:高額合算支給申請書（写）・変更
     */
    高額合算支給申請書_写_登録_変更申請("6", "高額合算　支給申請書（写）・変更", "高額合算支給申請書（写）・変更"),
    /**
     * コード:7 名称:高額合算支給申請書（写）登録・取下げ申請 略称:高額合算支給申請書（写）・取下げ
     */
    高額合算支給申請書_写_登録_取下げ申請("7", "高額合算　支給申請書（写）・取下げ", "高額合算支給申請書（写）・取下げ"),
    /**
     * コード:8 名称:高額合算支給申請書（写）訂正 略称:高額合算支給申請書（写）・訂正
     */
    高額合算支給申請書_写_訂正("8", "高額合算　支給申請書（写）・訂正", "高額合算支給申請書（写）・訂正"),
    /**
     * コード:9 名称:自己負担額証明書交付申請書登録・新規申請 略称:高額合算自己負担額証明書交付申請書登録・新規
     */
    自己負担額証明書交付申請書登録_新規申請("9", "高額合算　自己負担額証明書交付申請書登録・新規", "高額合算自己負担額証明書交付申請書登録・新規"),
    /**
     * コード:10 名称:自己負担額証明書交付申請書登録・変更申請 略称:高額合算自己負担額証明書交付申請書登録・変更
     */
    自己負担額証明書交付申請書登録_変更申請("10", "高額合算　自己負担額証明書交付申請書登録・変更", "高額合算自己負担額証明書交付申請書登録・変更"),
    /**
     * コード:11 名称:自己負担額証明書交付申請書登録・取下げ申請 略称:高額合算自己負担額証明書交付申請書登録・取下げ
     */
    自己負担額証明書交付申請書登録_取下げ申請("11", "高額合算　自己負担額証明書交付申請書登録・取下げ", "高額合算自己負担額証明書交付申請書登録・取下げ"),
    /**
     * コード:12 名称:自己負担額証明書交付申請書訂正 略称:高額合算自己負担額証明書交付申請書登録・訂正
     */
    自己負担額証明書交付申請書訂正("12", "高額合算　自己負担額証明書交付申請書登録・訂正", "高額合算自己負担額証明書交付申請書登録・訂正");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private Kaigogassan_ShikyushinseishoTorokugamenTitle(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 介護合算_支給申請書登録画面タイトルのコードを返します。
     *
     * @return 介護合算_支給申請書登録画面タイトルのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_支給申請書登録画面タイトルの名称を返します。
     *
     * @return 介護合算_支給申請書登録画面タイトルの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_支給申請書登録画面タイトルの略称を返します。
     *
     * @return 介護合算_支給申請書登録画面タイトルの略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 介護合算_支給申請書登録画面タイトルのコードと一致する内容を探します。
     *
     * @param code 介護合算_支給申請書登録画面タイトルのコード
     * @return {@code code} に対応する介護合算_支給申請書登録画面タイトル
     */
    public static Kaigogassan_ShikyushinseishoTorokugamenTitle toValue(RString code) {
        for (Kaigogassan_ShikyushinseishoTorokugamenTitle value : Kaigogassan_ShikyushinseishoTorokugamenTitle.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_支給申請書登録画面タイトル"));
    }
}
