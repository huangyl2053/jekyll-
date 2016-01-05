/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiiryokikanjohomaster;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 主治医医療機関情報を特定するためのMyBatis用パラメータクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class KoseiShujiiIryoKikanMasterMapperParameter {

    private final boolean 状況フラグ;
    private final LasdecCode 市町村コード;
    private final ShujiiIryokikanCode 主治医医療機関コードFrom;
    private final ShujiiIryokikanCode 主治医医療機関コードTo;
    private final RString 医療機関名称;
    private final RString 医療機関カナ名称;
    private final Decimal saidaiHyojiKensu;
    private final boolean uses市町村コード;
    private final boolean uses主治医医療機関コードFrom;
    private final boolean uses主治医医療機関コードTo;
    private final boolean uses医療機関名称;
    private final boolean uses医療機関カナ名称;
    private final boolean usesSaidaiHyojiKensu;

    private KoseiShujiiIryoKikanMasterMapperParameter(
            boolean 状況フラグ,
            LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コードFrom,
            ShujiiIryokikanCode 主治医医療機関コードTo,
            RString 医療機関名称,
            RString 医療機関カナ名称,
            Decimal saidaiHyojiKensu,
            boolean uses市町村コード,
            boolean uses主治医医療機関コードFrom,
            boolean uses主治医医療機関コードTo,
            boolean uses医療機関名称,
            boolean uses医療機関カナ名称,
            boolean usesSaidaiHyojiKensu) {

        this.状況フラグ = 状況フラグ;
        this.市町村コード = 市町村コード;
        this.主治医医療機関コードFrom = 主治医医療機関コードFrom;
        this.主治医医療機関コードTo = 主治医医療機関コードTo;
        this.医療機関名称 = 医療機関名称;
        this.医療機関カナ名称 = 医療機関カナ名称;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.uses市町村コード = uses市町村コード;
        this.uses主治医医療機関コードFrom = uses主治医医療機関コードFrom;
        this.uses主治医医療機関コードTo = uses主治医医療機関コードTo;
        this.uses医療機関名称 = uses医療機関名称;
        this.uses医療機関カナ名称 = uses医療機関カナ名称;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 状況フラグ 状況フラグ
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コードFrom 主治医医療機関コードFrom
     * @param 主治医医療機関コードTo 主治医医療機関コードTo
     * @param 医療機関名称 医療機関名称
     * @param 医療機関カナ名称 医療機関カナ名称
     * @param 最大表示件数 最大表示件数
     *
     * @return 主治医医療機関情報パラメータ
     */
    public static KoseiShujiiIryoKikanMasterMapperParameter createParam_SelectShujiiIryoKikanJohoList(
            boolean 状況フラグ,
            LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コードFrom,
            ShujiiIryokikanCode 主治医医療機関コードTo,
            RString 医療機関名称,
            RString 医療機関カナ名称,
            Decimal 最大表示件数
    ) {
        return new KoseiShujiiIryoKikanMasterMapperParameter(
                状況フラグ,
                市町村コード,
                主治医医療機関コードFrom,
                主治医医療機関コードTo,
                医療機関名称,
                医療機関カナ名称,
                最大表示件数,
                市町村コード != null && !市町村コード.isEmpty(),
                主治医医療機関コードFrom != null && !主治医医療機関コードFrom.value().isEmpty(),
                主治医医療機関コードTo != null && !主治医医療機関コードTo.value().isEmpty(),
                医療機関名称 != null && !医療機関名称.isEmpty(),
                医療機関カナ名称 != null && !医療機関カナ名称.isEmpty(),
                最大表示件数 != null);
    }
}
