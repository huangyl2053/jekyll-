package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiijoho;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class ShujiiMasterSearchParameter {

    private final LasdecCode 市町村コード;
    private final RString 主治医医療機関コード;
    private final RString 主治医コード;

    private ShujiiMasterSearchParameter(
            LasdecCode 市町村コード,
            RString 主治医医療機関コード,
            RString 主治医コード) {
        this.市町村コード = 市町村コード;
        this.主治医医療機関コード = 主治医医療機関コード;
        this.主治医コード = 主治医コード;
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     *
     * @return 主治医マスタパラメータ
     */
    public static ShujiiMasterSearchParameter createParamForSelectShujiiJoho(
            LasdecCode 市町村コード,
            RString 主治医医療機関コード,
            RString 主治医コード
    ) {
        return new ShujiiMasterSearchParameter(
                市町村コード, 主治医医療機関コード, 主治医コード);
    }
}
