/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所属機関一覧情報を取得するビジネスクラスです。
 */
public class ShozokuKikanIchiranFinderBusiness implements Serializable {

    private final ShozokuKikanIchiranEntity entity;

    public ShozokuKikanIchiranFinderBusiness(ShozokuKikanIchiranEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("所属機関一覧情報"));
        this.entity = entity;
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainNo();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * その他機関コードを返します。
     *
     * @return その他機関コード
     */
    public RString getその他機関コード() {
        return entity.getSonotaKikanCode();
    }

    /**
     * 認定調査委託先名を返します。
     *
     * @return 認定調査委託先名
     */
    public RString get認定調査委託先名() {
        return entity.getNinteichosaItakusakiMeisho();
    }

    /**
     * 主治医医療機関名称を返します。
     *
     * @return 主治医医療機関名称
     */
    public RString get主治医医療機関名称() {
        return entity.getShujiiIryokikanMeisho();
    }

    /**
     * その他機関名を返します。
     *
     * @return その他機関名
     */
    public RString getその他機関名() {
        return entity.getSonotaKikanMeisho();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

}
