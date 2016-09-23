/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710120;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistsaishinsakekka.HanyoListSaishinsaKekkaProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 再審査結果情報のパラメータ。
 *
 * @reamsid_L DBC-3105-020 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBC710120_HanyoListSaishinsaKekkaParameter extends BatchParameterBase {

    private static final String CHOHYOID = "chohyoId";
    private static final String SHUTSURYOKUJUNID = "shutsuryokujunId";
    private static final String SHUTSURYOKUKOMOKUID = "shutsuryokuKomokuId";
    private static final String KOMOKUMEIFUKA = "komokumeiFuka";
    private static final String RENBANFUKA = "renbanFuka";
    private static final String HITSUKEHENSHU = "hitsukeHenshu";
    private static final String HOKENSHACODE = "hokenshacode";
    private static final String KOKUHORENTORIATSUKAIFROM = "kokuhorentoriatsukaifrom";
    private static final String KOKUHORENTORIATSUKAINENETSUTO = "kokuhorentoriatsukainenetsuto";
    private static final String HOKENSHAKUBUN = "hokenshakubun";
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
    @BatchParameter(key = RENBANFUKA, name = "連番付加")
    private boolean renbanFuka;
    @BatchParameter(key = HITSUKEHENSHU, name = "日付編集")
    private boolean hitsukeHenshu;
    @BatchParameter(key = HOKENSHACODE, name = "保険者コード")
    private LasdecCode hokenshacode;
    @BatchParameter(key = KOKUHORENTORIATSUKAIFROM, name = "国保連取扱年月From")
    private RString kokuhorentoriatsukaifrom;
    @BatchParameter(key = KOKUHORENTORIATSUKAINENETSUTO, name = "国保連取扱年月To")
    private RString kokuhorentoriatsukainenetsuto;
    @BatchParameter(key = HOKENSHAKUBUN, name = "保険者区分s")
    private List<RString> hokenshakubun;
    @BatchParameter(key = SEVERTEIKYOUNENGETSUFROM, name = "サービス提供年月From")
    private RString severteikyounengetsufrom;
    @BatchParameter(key = SEVERTEIKYOUNENGETSUTO, name = "サービス提供年月To")
    private RString severteikyounengetsuto;
    @BatchParameter(key = JIGYOUSHABANGOU, name = "事業者番号")
    private RString jigyoushabangou;

    /**
     * コンストラクタです。
     */
    public DBC710120_HanyoListSaishinsaKekkaParameter() {
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
     * @param kokuhorentoriatsukaifrom RString
     * @param kokuhorentoriatsukainenetsuto RString
     * @param hokenshakubun List<RString>
     * @param severteikyounengetsufrom RDate
     * @param severteikyounengetsuto RDate
     * @param jigyoushabangou RString
     */
    public DBC710120_HanyoListSaishinsaKekkaParameter(
            RString chohyoId,
            Long shutsuryokujunId,
            RString shutsuryokuKomokuId,
            boolean komokumeiFuka,
            boolean renbanFuka,
            boolean hitsukeHenshu,
            LasdecCode hokenshacode,
            RString kokuhorentoriatsukaifrom,
            RString kokuhorentoriatsukainenetsuto,
            List<RString> hokenshakubun,
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
        this.kokuhorentoriatsukaifrom = kokuhorentoriatsukaifrom;
        this.kokuhorentoriatsukainenetsuto = kokuhorentoriatsukainenetsuto;
        this.hokenshakubun = hokenshakubun;
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
    public HanyoListSaishinsaKekkaProcessParameter toHanyoListSaishinsaKekkaProcessParameterr(FlexibleDate date) {
        return new HanyoListSaishinsaKekkaProcessParameter(
                chohyoId,
                shutsuryokujunId,
                shutsuryokuKomokuId,
                komokumeiFuka,
                renbanFuka,
                hitsukeHenshu,
                hokenshacode,
                kokuhorentoriatsukaifrom,
                kokuhorentoriatsukainenetsuto,
                hokenshakubun,
                severteikyounengetsufrom,
                severteikyounengetsuto,
                jigyoushabangou,
                date
        );
    }
}
