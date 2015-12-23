package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosainmaster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 調査員情報を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class NinteiChosainMasterSearchParameter {

    private final LasdecCode 市町村コード;
    private final ChosaItakusakiCode 調査委託先コード;
    private final ChosainCode 調査員コード;

    private NinteiChosainMasterSearchParameter(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 調査委託先コード,
            ChosainCode 調査員コード) {
        this.市町村コード = 市町村コード;
        this.調査委託先コード = 調査委託先コード;
        this.調査員コード = 調査員コード;
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 調査委託先コード 調査委託先コード
     * @param 調査員コード 調査員コード
     *
     * @return 調査員マスタパラメータ
     */
    public static NinteiChosainMasterSearchParameter createParamForSelectChosainJoho(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 調査委託先コード,
            ChosainCode 調査員コード
    ) {

        return new NinteiChosainMasterSearchParameter(
                市町村コード, 調査委託先コード, 調査員コード);
    }
}
