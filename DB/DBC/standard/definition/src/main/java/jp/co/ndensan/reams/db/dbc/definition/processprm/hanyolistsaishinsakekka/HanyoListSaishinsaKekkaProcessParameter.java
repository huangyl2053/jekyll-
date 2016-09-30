/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistsaishinsakekka;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト 再審査結果情報のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-3105-020 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListSaishinsaKekkaProcessParameter implements IBatchProcessParameter {

    private RString chohyoId;
    private Long shutsuryokujunId;
    private RString shutsuryokuKomokuId;
    private boolean komokumeiFuka;
    private boolean renbanFuka;
    private boolean hitsukeHenshu;
    private LasdecCode hokenshacode;
    private RString kokuhorentoriatsukaiFrom;
    private RString kokuhorentoriatsukaiNengetsuTo;
    private List<RString> hokenshaKubunList;
    private RString severteikyounengetsuFrom;
    private RString severteikyounengetsuTo;
    private RString jigyoushabangou;
    private FlexibleDate date;

    /**
     *
     * @param chohyoId chohyoId
     * @param shutsuryokujunId shutsuryokujunId
     * @param shutsuryokuKomokuId shutsuryokuKomokuId
     * @param komokumeiFuka komokumeiFuka
     * @param renbanFuka renbanFuka
     * @param hitsukeHenshu hitsukeHenshu
     * @param hokenshacode hokenshacode
     * @param kokuhorensouhunengetsufrom kokuhorensouhunengetsufrom
     * @param kokuhorensouhunengetsuto kokuhorensouhunengetsuto
     * @param hokenshaKubunList hokenshaKubunList
     * @param severteikyounengetsufrom severteikyounengetsufrom
     * @param severteikyounengetsuto severteikyounengetsuto
     * @param jigyoushabangou jigyoushabangou
     * @param date date
     */
    public HanyoListSaishinsaKekkaProcessParameter(
            RString chohyoId,
            Long shutsuryokujunId,
            RString shutsuryokuKomokuId,
            boolean komokumeiFuka,
            boolean renbanFuka,
            boolean hitsukeHenshu,
            LasdecCode hokenshacode,
            RString kokuhorensouhunengetsufrom,
            RString kokuhorensouhunengetsuto,
            List<RString> hokenshaKubunList,
            RString severteikyounengetsufrom,
            RString severteikyounengetsuto,
            RString jigyoushabangou,
            FlexibleDate date) {
        this.chohyoId = chohyoId;
        this.shutsuryokujunId = shutsuryokujunId;
        this.shutsuryokuKomokuId = shutsuryokuKomokuId;
        this.komokumeiFuka = komokumeiFuka;
        this.renbanFuka = renbanFuka;
        this.hitsukeHenshu = hitsukeHenshu;
        this.hokenshacode = hokenshacode;
        this.kokuhorentoriatsukaiFrom = kokuhorensouhunengetsufrom;
        this.kokuhorentoriatsukaiNengetsuTo = kokuhorensouhunengetsuto;
        this.hokenshaKubunList = hokenshaKubunList;
        this.severteikyounengetsuFrom = severteikyounengetsufrom;
        this.severteikyounengetsuTo = severteikyounengetsuto;
        this.jigyoushabangou = jigyoushabangou;
        this.date = date;
    }
}
