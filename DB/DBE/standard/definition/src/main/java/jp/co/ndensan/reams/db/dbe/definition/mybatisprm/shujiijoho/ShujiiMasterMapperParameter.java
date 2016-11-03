/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiijoho;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 主治医マスタ用パラメータクラスです。
 *
 * @reamsid_L DBE-0250-010  suguangjun 
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShujiiMasterMapperParameter {

    private final LasdecCode 市町村コード;
    private final boolean 状況フラグ;
    private final RString 主治医医療機関コードFrom;
    private final RString 主治医医療機関コードTo;
    private final RString 主治医医療機関名称;
    private final RString 主治医医療機関名称キー;
    private final RString 主治医医療機関カナ名称;
    private final RString 主治医医療機関カナ名称キー;
    private final RString 主治医コードFrom;
    private final RString 主治医コードTo;
    private final RString 主治医氏名;
    private final RString 主治医氏名キー;
    private final AtenaKanaMeisho 主治医カナ氏名;
    private final RString 主治医カナ氏名キー;
    private final Decimal saidaiHyojiKensu;
    private final RString 市町村識別ID;

    private final boolean uses市町村コード;
    private final boolean uses主治医医療機関コードFrom;
    private final boolean uses主治医医療機関コードTo;
    private final boolean uses主治医医療機関名称;
    private final boolean uses0主治医医療機関名称;
    private final boolean uses1主治医医療機関名称;
    private final boolean uses2主治医医療機関名称;
    private final boolean uses3主治医医療機関名称;
    private final boolean uses主治医医療機関カナ名称;
    private final boolean uses0主治医医療機関カナ名称;
    private final boolean uses1主治医医療機関カナ名称;
    private final boolean uses2主治医医療機関カナ名称;
    private final boolean uses3主治医医療機関カナ名称;
    private final boolean uses主治医コードFrom;
    private final boolean uses主治医コードTo;
    private final boolean uses主治医氏名;
    private final boolean uses0主治医氏名;
    private final boolean uses1主治医氏名;
    private final boolean uses2主治医氏名;
    private final boolean uses3主治医氏名;
    private final boolean uses主治医カナ氏名;
    private final boolean uses0主治医カナ氏名;
    private final boolean uses1主治医カナ氏名;
    private final boolean uses2主治医カナ氏名;
    private final boolean uses3主治医カナ氏名;
    private final boolean usesSaidaiHyojiKensu;
    private final boolean 市町村識別ID利用Flag;
    private static final RString KEY_0 = new RString("0");
    private static final RString KEY_1 = new RString("1");
    private static final RString KEY_2 = new RString("2");
    private static final RString KEY_3 = new RString("3");
    private static final RString 構成市町村マスタ市町村コード重複 = new RString("1");

    private ShujiiMasterMapperParameter(
            LasdecCode 市町村コード,
            boolean 状況フラグ,
            RString 主治医医療機関コードFrom,
            RString 主治医医療機関コードTo,
            RString 主治医医療機関名称,
            RString 主治医医療機関名称キー,
            RString 主治医医療機関カナ名称,
            RString 主治医医療機関カナ名称キー,
            RString 主治医コードFrom,
            RString 主治医コードTo,
            RString 主治医氏名,
            RString 主治医氏名キー,
            AtenaKanaMeisho 主治医カナ氏名,
            RString 主治医カナ氏名キー,
            Decimal saidaiHyojiKensu,
            boolean uses市町村コード,
            boolean uses主治医医療機関コードFrom,
            boolean uses主治医医療機関コードTo,
            boolean uses主治医医療機関名称,
            boolean uses0主治医医療機関名称,
            boolean uses1主治医医療機関名称,
            boolean uses2主治医医療機関名称,
            boolean uses3主治医医療機関名称,
            boolean uses主治医医療機関カナ名称,
            boolean uses0主治医医療機関カナ名称,
            boolean uses1主治医医療機関カナ名称,
            boolean uses2主治医医療機関カナ名称,
            boolean uses3主治医医療機関カナ名称,
            boolean uses主治医コードFrom,
            boolean uses主治医コードTo,
            boolean uses主治医氏名,
            boolean uses0主治医氏名,
            boolean uses1主治医氏名,
            boolean uses2主治医氏名,
            boolean uses3主治医氏名,
            boolean uses主治医カナ氏名,
            boolean uses0主治医カナ氏名,
            boolean uses1主治医カナ氏名,
            boolean uses2主治医カナ氏名,
            boolean uses3主治医カナ氏名,
            boolean usesSaidaiHyojiKensu,
            RString 市町村識別ID,
            boolean 市町村識別ID利用Flag
    ) {
        this.市町村コード = 市町村コード;
        this.状況フラグ = 状況フラグ;
        this.主治医医療機関コードFrom = 主治医医療機関コードFrom;
        this.主治医医療機関コードTo = 主治医医療機関コードTo;
        this.主治医医療機関名称 = 主治医医療機関名称;
        this.主治医医療機関名称キー = 主治医医療機関名称キー;
        this.主治医医療機関カナ名称 = 主治医医療機関カナ名称;
        this.主治医医療機関カナ名称キー = 主治医医療機関カナ名称キー;
        this.主治医コードFrom = 主治医コードFrom;
        this.主治医コードTo = 主治医コードTo;
        this.主治医氏名 = 主治医氏名;
        this.主治医氏名キー = 主治医氏名キー;
        this.主治医カナ氏名 = 主治医カナ氏名;
        this.主治医カナ氏名キー = 主治医カナ氏名キー;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.uses市町村コード = uses市町村コード;
        this.uses主治医医療機関コードFrom = uses主治医医療機関コードFrom;
        this.uses主治医医療機関コードTo = uses主治医医療機関コードTo;
        this.uses主治医医療機関名称 = uses主治医医療機関名称;
        this.uses0主治医医療機関名称 = uses0主治医医療機関名称;
        this.uses1主治医医療機関名称 = uses1主治医医療機関名称;
        this.uses2主治医医療機関名称 = uses2主治医医療機関名称;
        this.uses3主治医医療機関名称 = uses3主治医医療機関名称;
        this.uses主治医医療機関カナ名称 = uses主治医医療機関カナ名称;
        this.uses0主治医医療機関カナ名称 = uses0主治医医療機関カナ名称;
        this.uses1主治医医療機関カナ名称 = uses1主治医医療機関カナ名称;
        this.uses2主治医医療機関カナ名称 = uses2主治医医療機関カナ名称;
        this.uses3主治医医療機関カナ名称 = uses3主治医医療機関カナ名称;
        this.uses主治医コードFrom = uses主治医コードFrom;
        this.uses主治医コードTo = uses主治医コードTo;
        this.uses主治医氏名 = uses主治医氏名;
        this.uses0主治医氏名 = uses0主治医氏名;
        this.uses1主治医氏名 = uses1主治医氏名;
        this.uses2主治医氏名 = uses2主治医氏名;
        this.uses3主治医氏名 = uses3主治医氏名;
        this.uses主治医カナ氏名 = uses主治医カナ氏名;
        this.uses0主治医カナ氏名 = uses0主治医カナ氏名;
        this.uses1主治医カナ氏名 = uses1主治医カナ氏名;
        this.uses2主治医カナ氏名 = uses2主治医カナ氏名;
        this.uses3主治医カナ氏名 = uses3主治医カナ氏名;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
        this.市町村識別ID = 市町村識別ID;
        this.市町村識別ID利用Flag = 市町村識別ID利用Flag;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 状況フラグ 状況フラグ
     * @param 主治医医療機関コードFrom 主治医医療機関コードFrom
     * @param 主治医医療機関コードTo 主治医医療機関コードTo
     * @param 主治医医療機関名称 主治医医療機関名称
     * @param 主治医医療機関名称キー 主治医医療機関名称キー
     * @param 主治医医療機関カナ名称 主治医医療機関カナ名称
     * @param 主治医医療機関カナ名称キー 主治医医療機関カナ名称キー
     * @param 主治医コードFrom 主治医コードFrom
     * @param 主治医コードTo 主治医コードTo
     * @param 主治医氏名 主治医氏名
     * @param 主治医氏名キー 主治医氏名キー
     * @param 主治医カナ氏名 主治医カナ氏名
     * @param 最大表示件数 最大表示件数
     * @param 主治医カナ氏名キー 主治医カナ氏名キー
     * @param 市町村識別ID 市町村識別ID
     * @param 構成市町村マスタ市町村コード重複種別 構成市町村マスタ市町村コード重複種別
     * @return 主治医マスタ検索パラメータ
     */
    public static ShujiiMasterMapperParameter createSelectByKeyParam(
            LasdecCode 市町村コード,
            boolean 状況フラグ,
            RString 主治医医療機関コードFrom,
            RString 主治医医療機関コードTo,
            RString 主治医医療機関名称,
            RString 主治医医療機関名称キー,
            RString 主治医医療機関カナ名称,
            RString 主治医医療機関カナ名称キー,
            RString 主治医コードFrom,
            RString 主治医コードTo,
            RString 主治医氏名,
            RString 主治医氏名キー,
            AtenaKanaMeisho 主治医カナ氏名,
            RString 主治医カナ氏名キー,
            Decimal 最大表示件数,
            RString 市町村識別ID,
            RString 構成市町村マスタ市町村コード重複種別
    ) {
        return new ShujiiMasterMapperParameter(市町村コード,
                状況フラグ,
                主治医医療機関コードFrom,
                主治医医療機関コードTo,
                主治医医療機関名称,
                主治医医療機関名称キー,
                主治医医療機関カナ名称,
                主治医医療機関カナ名称キー,
                主治医コードFrom,
                主治医コードTo,
                主治医氏名,
                主治医氏名キー,
                主治医カナ氏名,
                主治医カナ氏名キー,
                最大表示件数,
                市町村コード != null && !市町村コード.isEmpty(),
                主治医医療機関コードFrom != null && !主治医医療機関コードFrom.isEmpty(),
                主治医医療機関コードTo != null && !主治医医療機関コードTo.isEmpty(),
                主治医医療機関名称 != null && !主治医医療機関名称.isEmpty(),
                KEY_0.equals(主治医医療機関名称キー),
                KEY_1.equals(主治医医療機関名称キー),
                KEY_2.equals(主治医医療機関名称キー),
                KEY_3.equals(主治医医療機関名称キー),
                主治医医療機関カナ名称 != null && !主治医医療機関カナ名称.isEmpty(),
                KEY_0.equals(主治医医療機関カナ名称キー),
                KEY_1.equals(主治医医療機関カナ名称キー),
                KEY_2.equals(主治医医療機関カナ名称キー),
                KEY_3.equals(主治医医療機関カナ名称キー),
                主治医コードFrom != null && !主治医コードFrom.isEmpty(),
                主治医コードTo != null && !主治医コードTo.isEmpty(),
                主治医氏名 != null && !主治医氏名.isEmpty(),
                KEY_0.equals(主治医氏名キー),
                KEY_1.equals(主治医氏名キー),
                KEY_2.equals(主治医氏名キー),
                KEY_3.equals(主治医氏名キー),
                主治医カナ氏名 != null && !主治医カナ氏名.isEmpty(),
                KEY_0.equals(主治医カナ氏名キー),
                KEY_1.equals(主治医カナ氏名キー),
                KEY_2.equals(主治医カナ氏名キー),
                KEY_3.equals(主治医カナ氏名キー),
                最大表示件数 != null,
                市町村識別ID,
                構成市町村マスタ市町村コード重複.equals(構成市町村マスタ市町村コード重複種別)
        );
    }
}
