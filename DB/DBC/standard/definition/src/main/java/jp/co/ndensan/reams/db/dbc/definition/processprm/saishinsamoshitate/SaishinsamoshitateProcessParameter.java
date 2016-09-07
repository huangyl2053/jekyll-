/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitate;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsamoshitate.SaishinsamoshitateMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト 再審査申立情報のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-3106-020 zhengsongling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsamoshitateProcessParameter implements IBatchProcessParameter {

    private RString chohyoId;
    private Long shutsuryokujunId;
    private RString shutsuryokuKomokuId;
    private boolean komokumeiFuka;
    private boolean renbanFuka;
    private boolean hitsukeHenshu;
    private LasdecCode hokenshacode;
    private RString kokuhorensouhunengetsufrom;
    private RString kokuhorensouhunengetsuto;
    private RString severteikyounengetsufrom;
    private RString severteikyounengetsuto;
    private RString jigyoushabangou;
    private boolean has国保連送付年月From;
    private boolean has国保連送付年月To;
    private boolean hasサービス提供年月From;
    private boolean hasサービス提供年月To;
    private boolean has事業者番号;
    private boolean has保険者コード;
    private RDate date;

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
     * @param severteikyounengetsufrom severteikyounengetsufrom
     * @param severteikyounengetsuto severteikyounengetsuto
     * @param jigyoushabangou jigyoushabangou
     * @param date date
     */
    public SaishinsamoshitateProcessParameter(
            RString chohyoId,
            Long shutsuryokujunId,
            RString shutsuryokuKomokuId,
            boolean komokumeiFuka,
            boolean renbanFuka,
            boolean hitsukeHenshu,
            LasdecCode hokenshacode,
            RString kokuhorensouhunengetsufrom,
            RString kokuhorensouhunengetsuto,
            RString severteikyounengetsufrom,
            RString severteikyounengetsuto,
            RString jigyoushabangou,
            RDate date) {
        this.chohyoId = chohyoId;
        this.shutsuryokujunId = shutsuryokujunId;
        this.shutsuryokuKomokuId = shutsuryokuKomokuId;
        this.komokumeiFuka = komokumeiFuka;
        this.renbanFuka = renbanFuka;
        this.hitsukeHenshu = hitsukeHenshu;
        this.hokenshacode = hokenshacode;
        this.kokuhorensouhunengetsufrom = kokuhorensouhunengetsufrom;
        this.kokuhorensouhunengetsuto = kokuhorensouhunengetsuto;
        this.severteikyounengetsufrom = severteikyounengetsufrom;
        this.severteikyounengetsuto = severteikyounengetsuto;
        this.jigyoushabangou = jigyoushabangou;
        this.date = date;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @return SaishinsamoshitateMybatisParameter
     */
    public SaishinsamoshitateMybatisParameter toSaishinsamoshitateMybatisParameter(RString psmShikibetsuTaisho) {
        return SaishinsamoshitateMybatisParameter.creatParameter(
                chohyoId,
                shutsuryokujunId,
                shutsuryokuKomokuId,
                komokumeiFuka,
                renbanFuka,
                hitsukeHenshu,
                hokenshacode,
                kokuhorensouhunengetsufrom,
                kokuhorensouhunengetsuto,
                severteikyounengetsufrom,
                severteikyounengetsuto,
                jigyoushabangou,
                has国保連送付年月From,
                has国保連送付年月To,
                hasサービス提供年月From,
                hasサービス提供年月To,
                has事業者番号,
                has保険者コード,
                date,
                psmShikibetsuTaisho);
    }
}
