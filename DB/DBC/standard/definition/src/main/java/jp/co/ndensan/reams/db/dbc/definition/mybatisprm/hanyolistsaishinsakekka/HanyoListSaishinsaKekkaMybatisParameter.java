/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistsaishinsakekka;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト 再審査結果情報のMybatis用パラメータクラスです。
 *
 * @reamsid_L DBC-3105-020 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HanyoListSaishinsaKekkaMybatisParameter implements IMyBatisParameter {

    private static final RString 保険者コード = new RString("000000");
    private final RString 出力順;
    private final boolean komokumeiFuka;
    private final boolean renbanFuka;
    private final boolean hitsukeHenshu;
    private final LasdecCode hokenshacode;
    private final RString 国保連取扱年月From;
    private final RString 国保連取扱年月To;
    private final List<RString> hokenshaKubunList;
    private final RString サービス提供年月From;
    private final RString サービス提供年月To;
    private final RString 事業者番号;
    private final boolean has国保連取扱年月From;
    private final boolean has国保連取扱年月To;
    private final boolean has保険者区分;
    private final boolean hasサービス提供年月From;
    private final boolean hasサービス提供年月To;
    private final boolean has事業者番号;
    private final boolean has保険者コード;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     */
    private HanyoListSaishinsaKekkaMybatisParameter(
            RString 出力順,
            boolean komokumeiFuka,
            boolean renbanFuka,
            boolean hitsukeHenshu,
            LasdecCode hokenshacode,
            RString 国保連取扱年月From,
            RString 国保連取扱年月To,
            List<RString> hokenshaKubunList,
            RString サービス提供年月From,
            RString サービス提供年月To,
            RString 事業者番号,
            boolean has国保連取扱年月From,
            boolean has国保連取扱年月To,
            boolean has保険者区分,
            boolean hasサービス提供年月From,
            boolean hasサービス提供年月To,
            boolean has事業者番号,
            boolean has保険者コード,
            RString psmShikibetsuTaisho
    ) {
        this.出力順 = 出力順;
        this.komokumeiFuka = komokumeiFuka;
        this.renbanFuka = renbanFuka;
        this.hitsukeHenshu = hitsukeHenshu;
        this.hokenshacode = hokenshacode;
        this.国保連取扱年月From = 国保連取扱年月From;
        this.国保連取扱年月To = 国保連取扱年月To;
        this.hokenshaKubunList = hokenshaKubunList;
        this.サービス提供年月From = サービス提供年月From;
        this.サービス提供年月To = サービス提供年月To;
        this.事業者番号 = 事業者番号;
        this.has国保連取扱年月From = has国保連取扱年月From;
        this.has国保連取扱年月To = has国保連取扱年月To;
        this.has保険者区分 = has保険者区分;
        this.hasサービス提供年月From = hasサービス提供年月From;
        this.hasサービス提供年月To = hasサービス提供年月To;
        this.has事業者番号 = has事業者番号;
        this.has保険者コード = has保険者コード;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;

    }

    /**
     * パラメータを作成します。
     *
     * @param 出力順 出力順
     * @param komokumeiFuka komokumeiFuka
     * @param renbanFuka renbanFuka
     * @param hitsukeHenshu hitsukeHenshu
     * @param hokenshacode hokenshacode
     * @param 国保連取扱年月From 国保連取扱年月From
     * @param 国保連取扱年月To 国保連取扱年月To
     * @param hokenshaKubunList hokenshaKubunList
     * @param サービス提供年月From サービス提供年月From
     * @param サービス提供年月To サービス提供年月To
     * @param 事業者番号 事業者番号
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @return HanyoListSaishinsaKekkaMybatisParameter
     */
    public static HanyoListSaishinsaKekkaMybatisParameter createMybatisParameter(
            RString 出力順,
            boolean komokumeiFuka,
            boolean renbanFuka,
            boolean hitsukeHenshu,
            LasdecCode hokenshacode,
            RString 国保連取扱年月From,
            RString 国保連取扱年月To,
            List<RString> hokenshaKubunList,
            RString サービス提供年月From,
            RString サービス提供年月To,
            RString 事業者番号,
            RString psmShikibetsuTaisho) {
        boolean has保険者区分 = false;
        boolean has保険者コード = false;
        boolean has国保連取扱年月From = isNotNull(国保連取扱年月From);
        boolean has国保連取扱年月To = isNotNull(国保連取扱年月To);
        boolean hasサービス提供年月From = isNotNull(サービス提供年月From);
        boolean hasサービス提供年月To = isNotNull(サービス提供年月To);
        boolean has事業者番号 = isNotNull(事業者番号);
        if (hokenshacode != null && !RString.isNullOrEmpty(hokenshacode.value()) && !保険者コード.equals(hokenshacode.value())) {
            has保険者コード = true;
        }
        if (!hokenshaKubunList.isEmpty()) {
            has保険者区分 = true;
        }
        return new HanyoListSaishinsaKekkaMybatisParameter(
                出力順,
                komokumeiFuka,
                renbanFuka,
                hitsukeHenshu,
                hokenshacode,
                国保連取扱年月From,
                国保連取扱年月To,
                hokenshaKubunList,
                サービス提供年月From,
                サービス提供年月To,
                事業者番号,
                has国保連取扱年月From,
                has国保連取扱年月To,
                has保険者区分,
                hasサービス提供年月From,
                hasサービス提供年月To,
                has事業者番号,
                has保険者コード,
                psmShikibetsuTaisho
        );
    }

    private static boolean isNotNull(RString value) {
        boolean flag = false;
        if (!RString.isNullOrEmpty(value)) {
            flag = true;
        }
        return flag;
    }
}
