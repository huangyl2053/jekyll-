package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosainmaster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 調査員情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0280-010 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class NinteiChosainMasterMapperParameter {

    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString KEY3 = new RString("3");
    private final boolean 状況フラグ;
    private final LasdecCode 市町村コード;
    private final ChosaItakusakiCode 調査委託先コードFrom;
    private final ChosaItakusakiCode 調査委託先コードTo;

    private final RString 調査委託先名称;
    private final RString 調査委託先カナ名称;
    private final ChosainCode 調査員コードFrom;
    private final ChosainCode 調査員コードTo;
    private final RString 調査員氏名;
    private final RString 調査員カナ氏名;
    private final RString 地区コード;
    private final Decimal saidaiHyojiKensu;
    private final RString 市町村識別ID;
    private static final RString 構成市町村マスタ市町村コード重複 = new RString("1");
    
    private final boolean uses市町村コード;
    private final boolean uses調査委託先コードFrom;
    private final boolean uses調査委託先コードTo;
    private final boolean uses調査委託先名称;
    private final boolean uses調査委託先カナ名称;
    private final boolean uses調査員コードFrom;
    private final boolean uses調査員コードTo;
    private final boolean uses調査員氏名;
    private final boolean uses調査員カナ氏名;
    private final boolean uses地区コード;
    private final boolean usesSaidaiHyojiKensu;
    private final boolean uses委託先名称前方一致;
    private final boolean uses委託先名称後方一致;
    private final boolean uses委託先名称完全一致;
    private final boolean uses委託先名称部分一致;
    private final boolean uses委託先カナ名称前方一致;
    private final boolean uses委託先カナ名称後方一致;
    private final boolean uses委託先カナ名称完全一致;
    private final boolean uses委託先カナ名称部分一致;
    private final boolean uses調査員氏名前方一致;
    private final boolean uses調査員氏名後方一致;
    private final boolean uses調査員氏名完全一致;
    private final boolean uses調査員氏名部分一致;
    private final boolean uses調査員カナ氏名前方一致;
    private final boolean uses調査員カナ氏名後方一致;
    private final boolean uses調査員カナ氏名完全一致;
    private final boolean uses調査員カナ氏名部分一致;
    private final boolean 市町村識別ID利用Flag;

    private NinteiChosainMasterMapperParameter(
            boolean 状況フラグ,
            LasdecCode 市町村コード,
            ChosaItakusakiCode 調査委託先コードFrom,
            ChosaItakusakiCode 調査委託先コードTo,
            RString 調査委託先名称,
            RString 調査委託先カナ名称,
            ChosainCode 調査員コードFrom,
            ChosainCode 調査員コードTo,
            RString 調査員氏名,
            RString 調査員カナ氏名,
            RString 地区コード,
            Decimal saidaiHyojiKensu,
            boolean uses市町村コード,
            boolean uses調査委託先コードFrom,
            boolean uses調査委託先コードTo,
            boolean uses調査委託先名称,
            boolean uses調査委託先カナ名称,
            boolean uses調査員コードFrom,
            boolean uses調査員コードTo,
            boolean uses調査員氏名,
            boolean uses調査員カナ氏名,
            boolean uses地区コード,
            boolean usesSaidaiHyojiKensu,
            boolean uses委託先名称前方一致,
            boolean uses委託先名称後方一致,
            boolean uses委託先名称完全一致,
            boolean uses委託先名称部分一致,
            boolean uses委託先カナ名称前方一致,
            boolean uses委託先カナ名称後方一致,
            boolean uses委託先カナ名称完全一致,
            boolean uses委託先カナ名称部分一致,
            boolean uses調査員氏名前方一致,
            boolean uses調査員氏名後方一致,
            boolean uses調査員氏名完全一致,
            boolean uses調査員氏名部分一致,
            boolean uses調査員カナ氏名前方一致,
            boolean uses調査員カナ氏名後方一致,
            boolean uses調査員カナ氏名完全一致,
            boolean uses調査員カナ氏名部分一致,
            RString 市町村識別ID,  
            boolean 市町村識別ID利用Flag) {

        this.状況フラグ = 状況フラグ;
        this.市町村コード = 市町村コード;
        this.調査委託先コードFrom = 調査委託先コードFrom;
        this.調査委託先コードTo = 調査委託先コードTo;
        this.調査委託先名称 = 調査委託先名称;
        this.調査委託先カナ名称 = 調査委託先カナ名称;
        this.調査員コードFrom = 調査員コードFrom;
        this.調査員コードTo = 調査員コードTo;
        this.調査員氏名 = 調査員氏名;
        this.調査員カナ氏名 = 調査員カナ氏名;
        this.地区コード = 地区コード;
        this.uses市町村コード = uses市町村コード;
        this.uses調査委託先コードFrom = uses調査委託先コードFrom;
        this.uses調査委託先コードTo = uses調査委託先コードTo;
        this.uses調査委託先名称 = uses調査委託先名称;
        this.uses調査委託先カナ名称 = uses調査委託先カナ名称;
        this.uses調査員コードFrom = uses調査員コードFrom;
        this.uses調査員コードTo = uses調査員コードTo;
        this.uses調査員氏名 = uses調査員氏名;
        this.uses調査員カナ氏名 = uses調査員カナ氏名;
        this.uses地区コード = uses地区コード;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
        this.uses委託先名称前方一致 = uses委託先名称前方一致;
        this.uses委託先名称後方一致 = uses委託先名称後方一致;
        this.uses委託先名称完全一致 = uses委託先名称完全一致;
        this.uses委託先名称部分一致 = uses委託先名称部分一致;
        this.uses委託先カナ名称前方一致 = uses委託先カナ名称前方一致;
        this.uses委託先カナ名称後方一致 = uses委託先カナ名称後方一致;
        this.uses委託先カナ名称完全一致 = uses委託先カナ名称完全一致;
        this.uses委託先カナ名称部分一致 = uses委託先カナ名称部分一致;
        this.uses調査員氏名前方一致 = uses調査員氏名前方一致;
        this.uses調査員氏名後方一致 = uses調査員氏名後方一致;
        this.uses調査員氏名完全一致 = uses調査員氏名完全一致;
        this.uses調査員氏名部分一致 = uses調査員氏名部分一致;
        this.uses調査員カナ氏名前方一致 = uses調査員カナ氏名前方一致;
        this.uses調査員カナ氏名後方一致 = uses調査員カナ氏名後方一致;
        this.uses調査員カナ氏名完全一致 = uses調査員カナ氏名完全一致;
        this.uses調査員カナ氏名部分一致 = uses調査員カナ氏名部分一致;
        this.市町村識別ID = 市町村識別ID;
        this.市町村識別ID利用Flag = 市町村識別ID利用Flag;
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 状況フラグ 状況フラグ
     * @param 市町村コード 市町村コード
     * @param 調査委託先コードFrom 調査委託先コードFrom
     * @param 調査委託先コードTo 調査委託先コードTo
     * @param 調査委託先名称 調査委託先名称
     * @param 調査委託先名称キー 調査委託先名称キー
     * @param 調査委託先カナ名称 調査委託先カナ名称
     * @param 調査委託先カナ名称キー 調査委託先カナ名称キー
     * @param 調査員コードFrom 調査員コードFrom
     * @param 調査員コードTo 調査員コードTo
     * @param 調査員氏名 調査員氏名
     * @param 調査員氏名キー 調査員氏名キー
     * @param 調査員カナ氏名 調査員カナ氏名
     * @param 調査員カナ氏名キー 調査員カナ氏名キー
     * @param 地区コード 地区コード
     * @param 最大表示件数 最大表示件数
     * @param 市町村識別ID 市町村識別ID
     * @param 構成市町村マスタ市町村コード重複種別 構成市町村マスタ市町村コード重複種別
     *
     * @return 構成市町村マスタパラメータ
     */
    public static NinteiChosainMasterMapperParameter createParamForSelectChosainJohoList(
            boolean 状況フラグ,
            LasdecCode 市町村コード,
            ChosaItakusakiCode 調査委託先コードFrom,
            ChosaItakusakiCode 調査委託先コードTo,
            RString 調査委託先名称,
            RString 調査委託先名称キー,
            RString 調査委託先カナ名称,
            RString 調査委託先カナ名称キー,
            ChosainCode 調査員コードFrom,
            ChosainCode 調査員コードTo,
            RString 調査員氏名,
            RString 調査員氏名キー,
            RString 調査員カナ氏名,
            RString 調査員カナ氏名キー,
            RString 地区コード,
            Decimal 最大表示件数,
            RString 市町村識別ID, 
            RString 構成市町村マスタ市町村コード重複種別
    ) {
        return new NinteiChosainMasterMapperParameter(
                状況フラグ,
                市町村コード,
                調査委託先コードFrom,
                調査委託先コードTo,
                調査委託先名称,
                調査委託先カナ名称,
                調査員コードFrom,
                調査員コードTo,
                調査員氏名,
                調査員カナ氏名,
                地区コード,
                最大表示件数,
                市町村コード != null && !市町村コード.isEmpty(),
                調査委託先コードFrom != null && !調査委託先コードFrom.value().isEmpty(),
                調査委託先コードTo != null && !調査委託先コードTo.value().isEmpty(),
                調査委託先名称 != null && !調査委託先名称.isEmpty(),
                調査委託先カナ名称 != null && !調査委託先カナ名称.isEmpty(),
                調査員コードFrom != null && !調査員コードFrom.value().isEmpty(),
                調査員コードTo != null && !調査員コードTo.value().isEmpty(),
                調査員氏名 != null && !調査員氏名.isEmpty(),
                調査員カナ氏名 != null && !調査員カナ氏名.isEmpty(),
                地区コード != null && !地区コード.isEmpty(),
                最大表示件数 != null,
                KEY0.equals(調査委託先名称キー),
                KEY1.equals(調査委託先名称キー),
                KEY2.equals(調査委託先名称キー),
                KEY3.equals(調査委託先名称キー),
                KEY0.equals(調査委託先カナ名称キー),
                KEY1.equals(調査委託先カナ名称キー),
                KEY2.equals(調査委託先カナ名称キー),
                KEY3.equals(調査委託先カナ名称キー),
                KEY0.equals(調査員氏名キー),
                KEY1.equals(調査員氏名キー),
                KEY2.equals(調査員氏名キー),
                KEY3.equals(調査員氏名キー),
                KEY0.equals(調査員カナ氏名キー),
                KEY1.equals(調査員カナ氏名キー),
                KEY2.equals(調査員カナ氏名キー),
                KEY3.equals(調査員カナ氏名キー),
                市町村識別ID,
                構成市町村マスタ市町村コード重複.equals(構成市町村マスタ市町村コード重複種別)
        );
    }
}
