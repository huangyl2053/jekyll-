/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsamoshitate;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト 再審査申立情報のMybatis用パラメータクラスです。
 *
 * @reamsid_L DBC-3106-020 zhengsongling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SaishinsamoshitateMybatisParameter implements IMyBatisParameter {

    private static final RString 保険者コード = new RString("000000");
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
    private final RString psmShikibetsuTaisho;

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
     * @param has国保連送付年月From has国保連送付年月From
     * @param has国保連送付年月To has国保連送付年月To
     * @param hasサービス提供年月From hasサービス提供年月From
     * @param hasサービス提供年月To hasサービス提供年月To
     * @param has事業者番号 has事業者番号
     * @param has保険者コード has保険者コード
     * @param date date
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     */
    private SaishinsamoshitateMybatisParameter(
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
            boolean has国保連送付年月From,
            boolean has国保連送付年月To,
            boolean hasサービス提供年月From,
            boolean hasサービス提供年月To,
            boolean has事業者番号,
            boolean has保険者コード,
            RDate date,
            RString psmShikibetsuTaisho
    ) {
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
        this.has国保連送付年月From = has国保連送付年月From;
        this.has国保連送付年月To = has国保連送付年月To;
        this.hasサービス提供年月From = hasサービス提供年月From;
        this.hasサービス提供年月To = hasサービス提供年月To;
        this.has事業者番号 = has事業者番号;
        this.has保険者コード = has保険者コード;
        this.date = date;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;

    }

    /**
     * パラメータを作成します。
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
     * @param has国保連送付年月From has国保連送付年月From
     * @param has国保連送付年月To has国保連送付年月To
     * @param hasサービス提供年月From hasサービス提供年月From
     * @param hasサービス提供年月To hasサービス提供年月To
     * @param has事業者番号 has事業者番号
     * @param has保険者コード has保険者コード
     * @param date date
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @return SaishinsamoshitateMybatisParameter
     */
    public static SaishinsamoshitateMybatisParameter creatParameter(
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
            boolean has国保連送付年月From,
            boolean has国保連送付年月To,
            boolean hasサービス提供年月From,
            boolean hasサービス提供年月To,
            boolean has事業者番号,
            boolean has保険者コード,
            RDate date,
            RString psmShikibetsuTaisho) {
        has国保連送付年月From = true;
        has国保連送付年月To = true;
        hasサービス提供年月From = true;
        hasサービス提供年月To = true;
        has事業者番号 = true;
        has保険者コード = true;
        if (kokuhorensouhunengetsufrom.isNullOrEmpty()) {
            has国保連送付年月From = false;
        }
        if (kokuhorensouhunengetsuto.isNullOrEmpty()) {
            has国保連送付年月To = false;
        }
        if (severteikyounengetsufrom.isNullOrEmpty()) {
            hasサービス提供年月From = false;
        }
        if (severteikyounengetsuto.isNullOrEmpty()) {
            hasサービス提供年月To = false;
        }
        if (jigyoushabangou.isNullOrEmpty()) {
            has事業者番号 = false;
        }
        if (hokenshacode.isEmpty() || 保険者コード.equals(hokenshacode.value())) {
            has保険者コード = false;
        }
        return new SaishinsamoshitateMybatisParameter(
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
                psmShikibetsuTaisho
        );
    }
}
