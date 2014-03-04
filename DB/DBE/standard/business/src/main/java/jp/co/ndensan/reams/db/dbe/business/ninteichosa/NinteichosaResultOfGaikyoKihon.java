/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査結果情報（概況調査基本）を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaResultOfGaikyoKihon {

    private final FlexibleDate 認定調査実施年月日;
    private final ChosaIraiKubun 認定調査依頼区分;
    private final RString 認定調査実施場所コード;
    private final RString 認定調査実施場所名称;
// TODO N8156 宮本 康 認定調査依頼担当者のチケット完了後に対応
//    private final NinteichosaIraiTaishosha 認定調査依頼対象者情報;
    private final ChosaKubun 認定調査区分;
    private final RString 概況特記事項;
    private final ShinsakaiFuriwakeKubun 審査会優先振分区分;

    /**
     * インスタンスを生成します。
     *
     * @param 認定調査実施年月日 認定調査実施年月日
     * @param 認定調査依頼区分 認定調査依頼区分
     * @param 認定調査実施場所コード 認定調査実施場所コード
     * @param 認定調査実施場所名称 認定調査実施場所名称
     * @param 認定調査区分 認定調査区分
     * @param 概況特記事項 概況特記事項
     * @param 審査会優先振分区分 審査会優先振分区分
     */
    public NinteichosaResultOfGaikyoKihon(
            FlexibleDate 認定調査実施年月日,
            ChosaIraiKubun 認定調査依頼区分,
            RString 認定調査実施場所コード,
            RString 認定調査実施場所名称,
            ChosaKubun 認定調査区分,
            RString 概況特記事項,
            ShinsakaiFuriwakeKubun 審査会優先振分区分) {
        this.認定調査実施年月日 = requireNonNull(認定調査実施年月日, Messages.E00001.replace("認定調査実施年月日").getMessage());
        this.認定調査依頼区分 = requireNonNull(認定調査依頼区分, Messages.E00001.replace("認定調査依頼区分").getMessage());
        this.認定調査実施場所コード = requireNonNull(認定調査実施場所コード, Messages.E00001.replace("認定調査実施場所コード").getMessage());
        this.認定調査実施場所名称 = requireNonNull(認定調査実施場所名称, Messages.E00001.replace("認定調査実施場所名称").getMessage());
        this.認定調査区分 = requireNonNull(認定調査区分, Messages.E00001.replace("認定調査区分").getMessage());
        this.概況特記事項 = requireNonNull(概況特記事項, Messages.E00001.replace("概況特記事項").getMessage());
        this.審査会優先振分区分 = requireNonNull(審査会優先振分区分, Messages.E00001.replace("審査会優先振分区分").getMessage());
    }

    /**
     * 認定調査実施年月日を返します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return 認定調査実施年月日;
    }

    /**
     * 認定調査依頼区分を返します。
     *
     * @return 認定調査依頼区分
     */
    public ChosaIraiKubun get認定調査依頼区分() {
        return 認定調査依頼区分;
    }

    /**
     * 認定調査実施場所コードを返します。
     *
     * @return 認定調査実施場所コード
     */
    public RString get認定調査実施場所コード() {
        return 認定調査実施場所コード;
    }

    /**
     * 認定調査実施場所名称を返します。
     *
     * @return 認定調査実施場所名称
     */
    public RString get認定調査実施場所名称() {
        return 認定調査実施場所名称;
    }

    /**
     * 認定調査区分を返します。
     *
     * @return 認定調査区分
     */
    public ChosaKubun get認定調査区分() {
        return 認定調査区分;
    }

    /**
     * 概況特記事項を返します。
     *
     * @return 概況特記事項
     */
    public RString get概況特記事項() {
        return 概況特記事項;
    }

    /**
     * 審査会優先振分区分を返します。
     *
     * @return 審査会優先振分区分
     */
    public ShinsakaiFuriwakeKubun get審査会優先振分区分() {
        return 審査会優先振分区分;
    }
}
