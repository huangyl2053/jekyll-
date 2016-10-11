package jp.co.ndensan.reams.db.dba.definition.core.hihokenshno;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者番号付番方法を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
public enum HihokenshaNoFubanHoho {

    /**
     * コード:1 名称:住民コード付番 略称:住民コード付番
     */
    住民コード付番("1", "住民コード付番", "住民コード付番"),
    /**
     * コード:2 名称:自動連番付番 略称:自動連番付番
     */
    自動連番付番("2", "自動連番付番", "自動連番付番"),
    /**
     * コード:3 名称:任意手入力付番 略称:任意手入力付番
     */
    任意手入力付番("3", "任意手入力付番", "任意手入力付番"),
    /**
     * コード:4 名称:カスタマイズ付番 略称:カスタマイズ付番
     */
    カスタマイズ付番("4", "カスタマイズ付番", "カスタマイズ付番"),
    /**
     * コード:5 名称:自動連番_MCD10付番 略称:自動連番＋MCD10付番
     */
    自動連番_MCD10付番("5", "自動連番_MCD10付番", "自動連番＋MCD10付番");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private HihokenshaNoFubanHoho(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 被保険者番号付番方法のコードを返します。
     *
     * @return 被保険者番号付番方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者番号付番方法の名称を返します。
     *
     * @return 被保険者番号付番方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者番号付番方法の略称を返します。
     *
     * @return 被保険者番号付番方法の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 被保険者番号付番方法のコードと一致する内容を探します。
     *
     * @param code 被保険者番号付番方法のコード
     * @return {@code code} に対応する被保険者番号付番方法
     */
    public static HihokenshaNoFubanHoho toValue(RString code) {
        for (HihokenshaNoFubanHoho hihokenshaNoFubanHoho : HihokenshaNoFubanHoho.values()) {
            if (hihokenshaNoFubanHoho.code.equals(code)) {
                return hihokenshaNoFubanHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者番号付番方法"));
    }
}
