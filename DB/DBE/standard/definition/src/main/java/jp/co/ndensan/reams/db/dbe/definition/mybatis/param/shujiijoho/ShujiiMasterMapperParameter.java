/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiijoho;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 主治医マスタ用パラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShujiiMasterMapperParameter {

    private final LasdecCode 市町村コード;
    private final boolean 状況フラグ;
    private final ShujiiIryokikanCode 主治医医療機関コードFrom;
    private final ShujiiIryokikanCode 主治医医療機関コードTo;
    private final RString 主治医医療機関名称;
    private final RString 主治医医療機関カナ名称;
    private final ShujiiCode 主治医コードFrom;
    private final ShujiiCode 主治医コードTo;
    private final RString 主治医氏名;
    private final AtenaKanaMeisho 主治医カナ氏名;
    private final Decimal saidaiHyojiKensu;

    private final boolean uses市町村コード;
    //private final boolean 状況フラグ;
    private final boolean uses主治医医療機関コードFrom;
    private final boolean uses主治医医療機関コードTo;
    private final boolean uses主治医医療機関名称;
    private final boolean uses主治医医療機関カナ名称;
    private final boolean uses主治医コードFrom;
    private final boolean uses主治医コードTo;
    private final boolean uses主治医氏名;
    private final boolean uses主治医カナ氏名;
    boolean usesSaidaiHyojiKensu;

    /**
     * コンストラクタです。
     *
     * @param shichonCode shichonCode
     * @param usesshichonCode usesshichonCode
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShujiiMasterMapperParameter(
            LasdecCode 市町村コード,
            boolean 状況フラグ,
            ShujiiIryokikanCode 主治医医療機関コードFrom,
            ShujiiIryokikanCode 主治医医療機関コードTo,
            RString 主治医医療機関名称,
            RString 主治医医療機関カナ名称,
            ShujiiCode 主治医コードFrom,
            ShujiiCode 主治医コードTo,
            RString 主治医氏名,
            AtenaKanaMeisho 主治医カナ氏名,
            Decimal saidaiHyojiKensu,
            boolean uses市町村コード,
            boolean uses主治医医療機関コードFrom,
            boolean uses主治医医療機関コードTo,
            boolean uses主治医医療機関名称,
            boolean uses主治医医療機関カナ名称,
            boolean uses主治医コードFrom,
            boolean uses主治医コードTo,
            boolean uses主治医氏名,
            boolean uses主治医カナ氏名,
            boolean usesSaidaiHyojiKensu
    ) {
        this.市町村コード = 市町村コード;
        this.状況フラグ = 状況フラグ;
        this.主治医医療機関コードFrom = 主治医医療機関コードFrom;
        this.主治医医療機関コードTo = 主治医医療機関コードTo;
        this.主治医医療機関名称 = 主治医医療機関名称;
        this.主治医医療機関カナ名称 = 主治医医療機関カナ名称;
        this.主治医コードFrom = 主治医コードFrom;
        this.主治医コードTo = 主治医コードTo;
        this.主治医氏名 = 主治医氏名;
        this.主治医カナ氏名 = 主治医カナ氏名;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.uses市町村コード = uses市町村コード;
        this.uses主治医医療機関コードFrom = uses主治医医療機関コードFrom;
        this.uses主治医医療機関コードTo = uses主治医医療機関コードTo;
        this.uses主治医医療機関名称 = uses主治医医療機関名称;
        this.uses主治医医療機関カナ名称 = uses主治医医療機関カナ名称;
        this.uses主治医コードFrom = uses主治医コードFrom;
        this.uses主治医コードTo = uses主治医コードTo;
        this.uses主治医氏名 = uses主治医氏名;
        this.uses主治医カナ氏名 = uses主治医カナ氏名;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 状況フラグ 状況フラグ
     * @param 主治医医療機関コードFrom 主治医医療機関コードFrom
     * @param 主治医医療機関コードTo 主治医医療機関コードTo
     * @param 主治医医療機関名称 主治医医療機関名称
     * @param 主治医医療機関カナ名称 主治医医療機関カナ名称
     * @param 主治医コードFrom 主治医コードFrom
     * @param 主治医コードTo 主治医コードTo
     * @param 主治医氏名 主治医氏名
     * @param 主治医カナ氏名 主治医カナ氏名
     * @param 最大表示件数 最大表示件数
     * @return 主治医マスタ検索パラメータ
     */
    public static ShujiiMasterMapperParameter createSelectByKeyParam(
            LasdecCode 市町村コード,
            boolean 状況フラグ,
            ShujiiIryokikanCode 主治医医療機関コードFrom,
            ShujiiIryokikanCode 主治医医療機関コードTo,
            RString 主治医医療機関名称,
            RString 主治医医療機関カナ名称,
            ShujiiCode 主治医コードFrom,
            ShujiiCode 主治医コードTo,
            RString 主治医氏名,
            AtenaKanaMeisho 主治医カナ氏名,
            Decimal 最大表示件数
    ) {
        boolean uses市町村コード = false;
        if (市町村コード != null || !市町村コード.isEmpty()) {
            uses市町村コード = true;
        }
        boolean uses主治医医療機関コードFrom = false;
        if (主治医医療機関コードFrom != null && !主治医医療機関コードFrom.value().isEmpty()) {
            uses主治医医療機関コードFrom = true;
        }
        boolean uses主治医医療機関コードTo = false;
        if (主治医医療機関コードTo != null && 主治医医療機関コードTo.value().isEmpty()) {
            uses主治医医療機関コードTo = true;
        }
        boolean uses主治医医療機関名称 = false;
        if (主治医医療機関名称 != null || !主治医医療機関名称.isEmpty()) {
            uses主治医医療機関名称 = true;
        }
        boolean uses主治医医療機関カナ名称 = false;
        if (主治医医療機関カナ名称 == null || 主治医医療機関カナ名称.isEmpty()) {
            uses主治医医療機関カナ名称 = true;
        }
        boolean uses主治医コードFrom = true;
        if (主治医コードFrom != null && 主治医コードFrom.value().isEmpty()) {
            uses主治医コードFrom = true;
        }
        boolean uses主治医コードTo = false;
        if (主治医コードTo != null && 主治医コードTo.value().isEmpty()) {
            uses主治医コードTo = true;
        }
        boolean uses主治医氏名 = false;
        if (主治医氏名 != null || !主治医氏名.isEmpty()) {
            uses主治医氏名 = true;
        }
        boolean uses主治医カナ氏名 = false;
        if (主治医カナ氏名 != null || !主治医カナ氏名.isEmpty()) {
            uses主治医カナ氏名 = true;
        }
        boolean usesSaidaiHyojiKensu = false;
        if (最大表示件数 != null) {
            usesSaidaiHyojiKensu = true;
        }

        return new ShujiiMasterMapperParameter(市町村コード,
                状況フラグ,
                主治医医療機関コードFrom,
                主治医医療機関コードTo,
                主治医医療機関名称,
                主治医医療機関カナ名称,
                主治医コードFrom,
                主治医コードTo,
                主治医氏名,
                主治医カナ氏名,
                最大表示件数,
                uses市町村コード,
                uses主治医医療機関コードFrom,
                uses主治医医療機関コードTo,
                uses主治医医療機関名称,
                uses主治医医療機関カナ名称,
                uses主治医コードFrom,
                uses主治医コードTo,
                uses主治医氏名,
                uses主治医カナ氏名,
                usesSaidaiHyojiKensu
        );
    }
}
