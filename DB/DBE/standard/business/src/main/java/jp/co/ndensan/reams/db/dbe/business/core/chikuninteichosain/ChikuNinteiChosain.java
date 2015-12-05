
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chikuninteichosain.ChosainJohoRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール詳細情報を管理するクラスです。
 */
public class ChikuNinteiChosain implements Serializable {

    private final ChosainJohoRelateEntity entity;

    public ChikuNinteiChosain(ChosainJohoRelateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール詳細情報"));
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 認定調査員氏名を返します。
     *
     * @return 認定調査員氏名
     */
    public RString get認定調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 認定調査予定開始時間を返します。
     *
     * @return 認定調査予定開始時間
     */
    public RString get認定調査予定開始時間() {
        return entity.getNinteiChosaYoteiKaishiTime();
    }

    /**
     * 認定調査予定終了時間を返します。
     *
     * @return 認定調査予定終了時間
     */
    public RString get認定調査予定終了時間() {
        return entity.getNinteiChosaYoteiShuryoTime();
    }

    /**
     * 認定調査時間枠数を返します。
     *
     * @return 認定調査時間枠数
     */
    public Code get認定調査時間枠数() {
        return entity.getNinteiChosaJikanWaku();
    }

}
