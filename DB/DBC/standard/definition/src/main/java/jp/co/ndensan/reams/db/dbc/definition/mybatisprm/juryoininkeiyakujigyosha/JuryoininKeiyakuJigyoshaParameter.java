/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.juryoininkeiyakujigyosha;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任契約事業者登録・追加・修正・照会MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-2120-030 panhe
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JuryoininKeiyakuJigyoshaParameter implements Serializable {

    private final boolean selectedBango;
    private final boolean selectedName;
    private final boolean selectedJusho;
    private final RString keiyakuJigyoshaNo;
    private final AtenaKanaMeisho keiyakuJigyoshaKanaName;
    private final boolean sameKanaName;
    private final AtenaMeisho keiyakuJigyoshaName;
    private final boolean sameJigyoshaName;
    private final RString keiyakuShurui;
    private final YubinNo keiyakuJigyoshaYubinNo;
    private final AtenaJusho keiyakuJigyoshaJusho;
    private final boolean sameJusho;

    /**
     * コンストラクタです
     *
     * @param selectedBango 契約事業者番号
     * @param selectedName 契約事業者名称
     * @param selectedJusho 契約事業者住所
     * @param keiyakuJigyoshaNo 事業者契約番号
     * @param keiyakuJigyoshaKanaName カナ名称
     * @param sameKanaName カナ名称前方一致
     * @param keiyakuJigyoshaName 漢字名称
     * @param sameJigyoshaName 漢字名称前方一致
     * @param keiyakuShurui 契約種類
     * @param keiyakuJigyoshaYubinNo 契約事業者郵便番号
     * @param keiyakuJigyoshaJusho 事業者住所
     * @param sameJusho 住所前方一致
     */
    private JuryoininKeiyakuJigyoshaParameter(
            boolean selectedBango,
            boolean selectedName,
            boolean selectedJusho,
            RString keiyakuJigyoshaNo,
            AtenaKanaMeisho keiyakuJigyoshaKanaName,
            boolean sameKanaName,
            AtenaMeisho keiyakuJigyoshaName,
            boolean sameJigyoshaName,
            RString keiyakuShurui,
            YubinNo keiyakuJigyoshaYubinNo,
            AtenaJusho keiyakuJigyoshaJusho,
            boolean sameJusho
    ) {
        this.selectedBango = selectedBango;
        this.selectedName = selectedName;
        this.selectedJusho = selectedJusho;
        this.keiyakuJigyoshaNo = keiyakuJigyoshaNo;
        this.keiyakuJigyoshaKanaName = keiyakuJigyoshaKanaName;
        this.sameKanaName = sameKanaName;
        this.keiyakuJigyoshaName = keiyakuJigyoshaName;
        this.sameJigyoshaName = sameJigyoshaName;
        this.keiyakuShurui = keiyakuShurui;
        this.keiyakuJigyoshaYubinNo = keiyakuJigyoshaYubinNo;
        this.keiyakuJigyoshaJusho = keiyakuJigyoshaJusho;
        this.sameJusho = sameJusho;
    }

    /**
     * 初期化
     *
     * @param selectedBango boolean
     * @param selectedName boolean
     * @param selectedJusho boolean
     * @param keiyakuJigyoshaNo RString
     * @param keiyakuJigyoshaKanaName AtenaKanaMeisho
     * @param sameKanaName boolean
     * @param keiyakuJigyoshaName AtenaMeisho
     * @param sameJigyoshaName boolean
     * @param keiyakuShurui RString
     * @param keiyakuJigyoshaYubinNo YubinNo
     * @param keiyakuJigyoshaJusho AtenaJusho
     * @param sameJusho boolean
     * @return JuryoininKeiyakuJigyoshaParameter
     */
    public static JuryoininKeiyakuJigyoshaParameter createMybatisParam(
            boolean selectedBango,
            boolean selectedName,
            boolean selectedJusho,
            RString keiyakuJigyoshaNo,
            AtenaKanaMeisho keiyakuJigyoshaKanaName,
            boolean sameKanaName,
            AtenaMeisho keiyakuJigyoshaName,
            boolean sameJigyoshaName,
            RString keiyakuShurui,
            YubinNo keiyakuJigyoshaYubinNo,
            AtenaJusho keiyakuJigyoshaJusho,
            boolean sameJusho
    ) {
        return new JuryoininKeiyakuJigyoshaParameter(
                selectedBango,
                selectedName,
                selectedJusho,
                keiyakuJigyoshaNo,
                keiyakuJigyoshaKanaName,
                sameKanaName,
                keiyakuJigyoshaName,
                sameJigyoshaName,
                keiyakuShurui,
                keiyakuJigyoshaYubinNo,
                keiyakuJigyoshaJusho,
                sameJusho
        );
    }
}
