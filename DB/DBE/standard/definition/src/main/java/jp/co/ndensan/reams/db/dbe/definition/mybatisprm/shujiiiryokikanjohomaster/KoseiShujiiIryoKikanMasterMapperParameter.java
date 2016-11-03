/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiiryokikanjohomaster;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 主治医医療機関情報を特定するためのMyBatis用パラメータクラスです。
 * @reamsid_L DBE-0240-010 dongyabin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class KoseiShujiiIryoKikanMasterMapperParameter {

    private static final RString 前方一致KEY = new RString("0");
    private static final RString 後方一致KEY = new RString("1");
    private static final RString 完全一致KEY = new RString("2");
    private static final RString 部分一致KEY = new RString("3");
    private static final RString 構成市町村マスタ市町村コード重複 = new RString("1");
    private final boolean 状況フラグ;
    private final LasdecCode 市町村コード;
    private final RString 主治医医療機関コードFrom;
    private final RString 主治医医療機関コードTo;
    private final RString 医療機関名称;
    private final RString 医療機関カナ名称;
    private final RString 市町村識別ID;
    private final Decimal saidaiHyojiKensu;
    private final boolean uses市町村コード;
    private final boolean uses主治医医療機関コードFrom;
    private final boolean uses主治医医療機関コードTo;
    private final boolean uses医療機関名称;
    private final boolean uses医療機関カナ名称;
    private final boolean usesSaidaiHyojiKensu;
    private final boolean 医療機関名称前方一致Flag;
    private final boolean 医療機関名称後方一致Flag;
    private final boolean 医療機関名称完全一致Flag;
    private final boolean 医療機関名称部分一致Flag;
    private final boolean 医療機関カナ名称前方一致Flag;
    private final boolean 医療機関カナ名称後方一致Flag;
    private final boolean 医療機関カナ名称完全一致Flag;
    private final boolean 医療機関カナ名称部分一致Flag;
    private final boolean 市町村識別ID利用Flag;

    private KoseiShujiiIryoKikanMasterMapperParameter(
            boolean 状況フラグ,
            LasdecCode 市町村コード,
            RString 主治医医療機関コードFrom,
            RString 主治医医療機関コードTo,
            RString 医療機関名称,
            RString 医療機関カナ名称,
            RString 市町村識別ID,
            Decimal saidaiHyojiKensu,
            boolean uses市町村コード,
            boolean uses主治医医療機関コードFrom,
            boolean uses主治医医療機関コードTo,
            boolean uses医療機関名称,
            boolean uses医療機関カナ名称,
            boolean usesSaidaiHyojiKensu,
            boolean 医療機関名称前方一致Flag,
            boolean 医療機関名称後方一致Flag,
            boolean 医療機関名称完全一致Flag,
            boolean 医療機関名称部分一致Flag,
            boolean 医療機関カナ名称前方一致Flag,
            boolean 医療機関カナ名称後方一致Flag,
            boolean 医療機関カナ名称完全一致Flag,
            boolean 医療機関カナ名称部分一致Flag,
            boolean 市町村識別ID利用Flag) {
        this.状況フラグ = 状況フラグ;
        this.市町村コード = 市町村コード;
        this.主治医医療機関コードFrom = 主治医医療機関コードFrom;
        this.主治医医療機関コードTo = 主治医医療機関コードTo;
        this.医療機関名称 = 医療機関名称;
        this.医療機関カナ名称 = 医療機関カナ名称;
        this.市町村識別ID = 市町村識別ID;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.uses市町村コード = uses市町村コード;
        this.uses主治医医療機関コードFrom = uses主治医医療機関コードFrom;
        this.uses主治医医療機関コードTo = uses主治医医療機関コードTo;
        this.uses医療機関名称 = uses医療機関名称;
        this.uses医療機関カナ名称 = uses医療機関カナ名称;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
        this.医療機関名称前方一致Flag = 医療機関名称前方一致Flag;
        this.医療機関名称後方一致Flag = 医療機関名称後方一致Flag;
        this.医療機関名称完全一致Flag = 医療機関名称完全一致Flag;
        this.医療機関名称部分一致Flag = 医療機関名称部分一致Flag;
        this.医療機関カナ名称前方一致Flag = 医療機関カナ名称前方一致Flag;
        this.医療機関カナ名称後方一致Flag = 医療機関カナ名称後方一致Flag;
        this.医療機関カナ名称完全一致Flag = 医療機関カナ名称完全一致Flag;
        this.医療機関カナ名称部分一致Flag = 医療機関カナ名称部分一致Flag;
        this.市町村識別ID利用Flag = 市町村識別ID利用Flag;
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 医療機関名称検索条件 医療機関名称検索条件
     * @param 医療機関カナ名称検索条件 医療機関カナ名称検索条件
     * @param 状況フラグ 状況フラグ
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コードFrom 主治医医療機関コードFrom
     * @param 主治医医療機関コードTo 主治医医療機関コードTo
     * @param 医療機関名称 医療機関名称
     * @param 医療機関カナ名称 医療機関カナ名称
     * @param 市町村識別ID 市町村識別ID
     * @param 最大表示件数 最大表示件数
     * @param 構成市町村マスタ市町村コード重複種別 構成市町村マスタ市町村コード重複種別
     *
     * @return 主治医医療機関情報パラメータ
     */
    public static KoseiShujiiIryoKikanMasterMapperParameter createParam_SelectShujiiIryoKikanJohoList(
            RString 医療機関名称検索条件,
            RString 医療機関カナ名称検索条件,
            boolean 状況フラグ,
            LasdecCode 市町村コード,
            RString 主治医医療機関コードFrom,
            RString 主治医医療機関コードTo,
            RString 医療機関名称,
            RString 医療機関カナ名称,
            RString 市町村識別ID,
            Decimal 最大表示件数,
            RString 構成市町村マスタ市町村コード重複種別) {
        return new KoseiShujiiIryoKikanMasterMapperParameter(
                状況フラグ,
                市町村コード,
                主治医医療機関コードFrom,
                主治医医療機関コードTo,
                医療機関名称,
                医療機関カナ名称,
                市町村識別ID,
                最大表示件数,
                市町村コード != null && !市町村コード.isEmpty(),
                主治医医療機関コードFrom != null && !主治医医療機関コードFrom.isEmpty(),
                主治医医療機関コードTo != null && !主治医医療機関コードTo.isEmpty(),
                医療機関名称 != null && !医療機関名称.isEmpty(),
                医療機関カナ名称 != null && !医療機関カナ名称.isEmpty(),
                最大表示件数 != null,
                前方一致KEY.equals(医療機関名称検索条件),
                後方一致KEY.equals(医療機関名称検索条件),
                完全一致KEY.equals(医療機関名称検索条件),
                部分一致KEY.equals(医療機関名称検索条件),
                前方一致KEY.equals(医療機関カナ名称検索条件),
                後方一致KEY.equals(医療機関カナ名称検索条件),
                完全一致KEY.equals(医療機関カナ名称検索条件),
                部分一致KEY.equals(医療機関カナ名称検索条件),
                構成市町村マスタ市町村コード重複.equals(構成市町村マスタ市町村コード重複種別));
    }
}
