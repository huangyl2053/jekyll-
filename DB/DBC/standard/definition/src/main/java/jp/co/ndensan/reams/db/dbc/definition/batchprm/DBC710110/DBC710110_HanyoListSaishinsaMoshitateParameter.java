/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710110;

import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitate.SaishinsamoshitateProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 再審査申立情報のパラメータ。
 *
 * @reamsid_L DBC-3106-020 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBC710110_HanyoListSaishinsaMoshitateParameter extends BatchParameterBase {

    private static final String CHOHYOID = "chohyoId";
    private static final String SHUTSURYOKUJUNID = "shutsuryokujunId";
    private static final String SHUTSURYOKUKOMOKUID = "shutsuryokuKomokuId";
    private static final String KOMOKUMEIFUKA = "komokumeiFuka";
    private static final String RENBANFUKA = "renbanFuka";
    private static final String HITSUKEHENSHU = "hitsukeHenshu";
    private static final String HOKENSHACODE = "hokenshacode";
    private static final String KOKUHORENSOUHUNENGETSUFROM = "kokuhorensouhunengetsufrom";
    private static final String KOKUHORENSOUHUNENGETSUTO = "kokuhorensouhunengetsuto";
    private static final String SEVERTEIKYOUNENGETSUFROM = "severteikyounengetsufrom";
    private static final String SEVERTEIKYOUNENGETSUTO = "severteikyounengetsuto";
    private static final String JIGYOUSHABANGOU = "jigyoushabangou";

    @BatchParameter(key = CHOHYOID, name = "帳票ID")
    private RString chohyoId;
    @BatchParameter(key = SHUTSURYOKUJUNID, name = "出力順ID")
    private Long shutsuryokujunId;
    @BatchParameter(key = SHUTSURYOKUKOMOKUID, name = "出力項目ID")
    private RString shutsuryokuKomokuId;
    @BatchParameter(key = KOMOKUMEIFUKA, name = "項目名付加")
    private boolean komokumeiFuka;
    @BatchParameter(key = RENBANFUKA, name = "連番付加 ")
    private boolean renbanFuka;
    @BatchParameter(key = HITSUKEHENSHU, name = "日付編集")
    private boolean hitsukeHenshu;
    @BatchParameter(key = HOKENSHACODE, name = "保険者コード")
    private LasdecCode hokenshacode;
    @BatchParameter(key = KOKUHORENSOUHUNENGETSUFROM, name = "国保連送付年月From")
    private RString kokuhorensouhunengetsufrom;
    @BatchParameter(key = KOKUHORENSOUHUNENGETSUTO, name = "国保連送付年月To")
    private RString kokuhorensouhunengetsuto;
    @BatchParameter(key = SEVERTEIKYOUNENGETSUFROM, name = "サービス提供年月From")
    private RString severteikyounengetsufrom;
    @BatchParameter(key = SEVERTEIKYOUNENGETSUTO, name = "サービス提供年月To")
    private RString severteikyounengetsuto;
    @BatchParameter(key = JIGYOUSHABANGOU, name = "事業者番号")
    private RString jigyoushabangou;

    /**
     * コンストラクタです。
     */
    public DBC710110_HanyoListSaishinsaMoshitateParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param chohyoId RString
     * @param shutsuryokujunId Long
     * @param shutsuryokuKomokuId RString
     * @param komokumeiFuka boolean
     * @param renbanFuka boolean
     * @param hitsukeHenshu boolean
     * @param hokenshacode LasdecCode
     * @param kokuhorensouhunengetsufrom RDate
     * @param kokuhorensouhunengetsuto RDate
     * @param severteikyounengetsufrom RDate
     * @param severteikyounengetsuto RDate
     * @param jigyoushabangou RString
     */
    public DBC710110_HanyoListSaishinsaMoshitateParameter(
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
            RString jigyoushabangou) {
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
    }

    /**
     * 汎用リスト 再審査申立情報のパラメータを作成します。
     *
     * @param date date
     * @return SaishinsamoshitateProcessParameter
     */
    public SaishinsamoshitateProcessParameter toSaishinsamoshitateProcessParameterr(RDate date) {
        return new SaishinsamoshitateProcessParameter(
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
                date
        );
    }
}
