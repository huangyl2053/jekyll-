/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 意見書記入項目マッピング09Aを表す列挙型です。
 */
public enum IkenshoKinyuMapping09A {

    /**
     * コード:1 名称:その他 略称:定義なし
     */
    その他("1", "問題行動の有の場合（その他）"),
    /**
     * コード:2 名称:その他の精神・神経症状 略称:定義なし
     */
    その他の精神_神経症状("2", "精神・神経症状の有無"),
    /**
     * コード:3 名称:専門医受診の有無 略称:定義なし
     */
    専門医受診の有無("3", "精神・神経症状の有の場合専門医受診の有無"),
    /**
     * コード:4 名称:身長 略称:定義なし
     */
    身長("4", "身長"),
    /**
     * コード:5 名称:体重 略称:定義なし
     */
    体重("5", "体重"),
    /**
     * コード:6 名称:四肢欠損 略称:定義なし
     */
    四肢欠損("6", "四肢欠損"),
    /**
     * コード:7 名称:麻痺_その他 略称:定義なし
     */
    麻痺_その他("7", "麻痺（その他）"),
    /**
     * コード:8 名称:筋力の低下 略称:定義なし
     */
    筋力の低下("8", "筋力の低下"),
    /**
     * コード:9 名称:関節の拘縮 略称:定義なし
     */
    関節の拘縮("9", "関節の拘縮"),
    /**
     * コード:10 名称:関節の痛み 略称:定義なし
     */
    関節の痛み("10", "関節の痛み"),
    /**
     * コード:11 名称:じょくそう 略称:定義なし
     */
    じょくそう("11", "じょくそう"),
    /**
     * コード:12 名称:その他の皮膚疾患 略称:定義なし
     */
    その他の皮膚疾患("12", "その他の皮膚疾患"),
    /**
     * コード:13 名称:栄養・食生活上の留意点 略称:定義なし
     */
    栄養_食生活上の留意点("13", "栄養・食生活上の留意点"),
    /**
     * コード:14 名称:病態_その他 略称:定義なし
     */
    病態_その他("14", "現在、今後発生の可能性が高い病態（その他）"),
    /**
     * コード:15 名称:病態_対処方針 略称:定義なし
     */
    病態_対処方針("15", "対処方針"),
    /**
     * コード:16 名称:その他の医療系のサービス 略称:定義なし
     */
    その他の医療系のサービス("16", "医学的管理の必要性（その他の医療系のサービス）"),
    /**
     * コード:17 名称:介護サービスの留意事項_血圧 略称:定義なし
     */
    介護サービスの留意事項_血圧("17", "介護サービスの留意事項（血圧）"),
    /**
     * コード:18 名称:介護サービスの留意事項_移動 略称:定義なし
     */
    介護サービスの留意事項_移動("18", "介護サービスの留意事項（移動）"),
    /**
     * コード:19 名称:介護サービスの留意事項_摂食 略称:定義なし
     */
    介護サービスの留意事項_摂食("19", "介護サービスの留意事項（摂食）"),
    /**
     * コード:20 名称:介護サービスの留意事項運動 略称:定義なし
     */
    介護サービスの留意事項_運動("20", "介護サービスの留意事項（運動）"),
    /**
     * コード:21 名称:介護サービスの留意事項_嚥下 略称:定義なし
     */
    介護サービスの留意事項_嚥下("21", "介護サービスの留意事項（嚥下）"),
    /**
     * コード:22 名称:介護サービスの留意事項_その他 略称:定義なし
     */
    介護サービスの留意事項_その他("22", "介護サービスの留意事項（その他）"),
    /**
     * コード:23 名称:感染症の有無 略称:定義なし
     */
    感染症の有無("23", "感染症の有無");

    private final RString code;
    private final RString fullName;

    private IkenshoKinyuMapping09A(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書記入項目マッピング09Aのコードを返します。
     *
     * @return 意見書記入項目マッピング09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書記入項目マッピング09Aの名称を返します。
     *
     * @return 意見書記入項目マッピング09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書記入項目マッピング09Aのコードと一致する内容を探します。
     *
     * @param code 意見書記入項目マッピング09Aのコード
     * @return {@code code} に対応する意見書記入項目マッピング09A
     */
    public static IkenshoKinyuMapping09A toValue(RString code) {
        for (IkenshoKinyuMapping09A ikenshoKinyuMapping99A : IkenshoKinyuMapping09A.values()) {
            if (ikenshoKinyuMapping99A.code.equals(code)) {
                return ikenshoKinyuMapping99A;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書記入項目マッピング09A"));
    }
}
