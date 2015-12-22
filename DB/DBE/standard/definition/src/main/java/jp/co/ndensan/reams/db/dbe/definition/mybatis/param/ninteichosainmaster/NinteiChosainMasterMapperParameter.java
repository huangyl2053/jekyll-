package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosainmaster;

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
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class NinteiChosainMasterMapperParameter {

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
            boolean usesSaidaiHyojiKensu) {

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
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 状況フラグ 状況フラグ
     * @param 市町村コード 市町村コード
     * @param 調査委託先コードFrom 調査委託先コードFrom
     * @param 調査委託先コードTo 調査委託先コードTo
     * @param 調査委託先名称 調査委託先名称
     * @param 調査委託先カナ名称 調査委託先カナ名称
     * @param 調査員コードFrom 調査員コードFrom
     * @param 調査員コードTo 調査員コードTo
     * @param 調査員氏名 調査員氏名
     * @param 調査員カナ氏名 調査員カナ氏名
     * @param 地区コード 地区コード
     * @param 最大表示件数 最大表示件数
     *
     * @return 構成市町村マスタパラメータ
     */
    public static NinteiChosainMasterMapperParameter createParamForSelectChosainJohoList(
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
            Decimal 最大表示件数
    ) {
        boolean uses市町村コード = false;
        if (市町村コード != null && !市町村コード.isEmpty()) {
            uses市町村コード = true;
        }
        boolean uses調査委託先コードFrom = false;
        if (調査委託先コードFrom != null && !調査委託先コードFrom.value().isEmpty()) {
            uses調査委託先コードFrom = true;
        }
        boolean uses調査委託先コードTo = false;
        if (調査委託先コードTo != null && !調査委託先コードTo.value().isEmpty()) {
            uses調査委託先コードTo = true;
        }
        boolean uses調査委託先名称 = false;
        if (調査委託先名称 != null && !調査委託先名称.isEmpty()) {
            uses調査委託先名称 = true;
        }
        boolean uses調査委託先カナ名称 = false;
        if (調査委託先カナ名称 != null && !調査委託先カナ名称.isEmpty()) {
            uses調査委託先カナ名称 = true;
        }
        boolean uses調査員コードFrom = false;
        if (調査員コードFrom != null && !調査員コードFrom.value().isEmpty()) {
            uses調査員コードFrom = true;
        }
        boolean uses調査員コードTo = false;
        if (調査員コードTo != null && !調査員コードTo.value().isEmpty()) {
            uses調査員コードTo = true;
        }
        boolean uses調査員氏名 = false;
        if (調査員氏名 != null && !調査員氏名.isEmpty()) {
            uses調査員氏名 = true;
        }
        boolean uses調査員カナ氏名 = false;
        if (調査員カナ氏名 != null && !調査員カナ氏名.isEmpty()) {
            uses調査員カナ氏名 = true;
        }
        boolean uses地区コード = false;
        if (地区コード != null && !地区コード.isEmpty()) {
            uses地区コード = true;
        }
        boolean usesSaidaiHyojiKensu = false;
        if (最大表示件数 != null) {
            usesSaidaiHyojiKensu = true;
        }
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
                uses市町村コード,
                uses調査委託先コードFrom,
                uses調査委託先コードTo,
                uses調査委託先名称,
                uses調査委託先カナ名称,
                uses調査員コードFrom,
                uses調査員コードTo,
                uses調査員氏名,
                uses調査員カナ氏名,
                uses地区コード,
                usesSaidaiHyojiKensu);
    }
}
