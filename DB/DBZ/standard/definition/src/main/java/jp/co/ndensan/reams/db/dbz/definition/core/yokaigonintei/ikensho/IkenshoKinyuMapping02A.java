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
 * 意見書記入項目マッピング02Aを表す列挙型です。
 */
public enum IkenshoKinyuMapping02A {

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
     * コード:7 名称:麻痺 略称:定義なし
     */
    麻痺("7", "麻痺"),
    /**
     * コード:8 名称:筋力の低下 略称:定義なし
     */
    筋力の低下("8", "筋力の低下"),
    /**
     * コード:9 名称:じょくそう 略称:定義なし
     */
    じょくそう("9", "じょくそう"),
    /**
     * コード:10 名称:その他の皮膚疾患 略称:定義なし
     */
    その他の皮膚疾患("10", "その他の皮膚疾患"),
    /**
     * コード:11 名称:病態_その他 略称:定義なし
     */
    病態_その他("11", "現在、今後発生の可能性が高い病態（その他）"),
    /**
     * コード:12 名称:病態_対処方針 略称:定義なし
     */
    病態_対処方針("12", "対処方針"),
    /**
     * コード:13 名称:その他の医療系のサービス 略称:定義なし
     */
    その他の医療系のサービス("13", "医学的管理の必要性（その他）"),
    /**
     * コード:14 名称:介護サービスの留意事項_血圧 略称:定義なし
     */
    介護サービスの留意事項_血圧("14", "介護サービスの留意事項（血圧）"),
    /**
     * コード:15 名称:介護サービスの留意事項_嚥下 略称:定義なし
     */
    介護サービスの留意事項_嚥下("15", "介護サービスの留意事項（嚥下）"),
    /**
     * コード:16 名称:介護サービスの留意事項_摂食 略称:定義なし
     */
    介護サービスの留意事項_摂食("16", "介護サービスの留意事項（摂食）"),
    /**
     * コード:17 名称:介護サービスの留意事項_移動 略称:定義なし
     */
    介護サービスの留意事項_移動("17", "介護サービスの留意事項（移動）"),
    /**
     * コード:18 名称:介護サービスの留意事項_その他 略称:定義なし
     */
    介護サービスの留意事項_その他("18", "介護サービスの留意事項（その他）"),
    /**
     * コード:19 名称:感染症の有無 略称:定義なし
     */
    感染症の有無("19", "感染症の有無");

    private final RString code;
    private final RString fullName;

    private IkenshoKinyuMapping02A(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書記入項目マッピング02Aのコードを返します。
     *
     * @return 意見書記入項目マッピング02Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書記入項目マッピング02Aの名称を返します。
     *
     * @return 意見書記入項目マッピング02Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書記入項目マッピング02Aのコードと一致する内容を探します。
     *
     * @param code 意見書記入項目マッピング02Aのコード
     * @return {@code code} に対応する意見書記入項目マッピング02A
     */
    public static IkenshoKinyuMapping02A toValue(RString code) {
        for (IkenshoKinyuMapping02A ikenshoKinyuMapping02A : IkenshoKinyuMapping02A.values()) {
            if (ikenshoKinyuMapping02A.code.equals(code)) {
                return ikenshoKinyuMapping02A;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書記入項目マッピング02A"));
    }
}
