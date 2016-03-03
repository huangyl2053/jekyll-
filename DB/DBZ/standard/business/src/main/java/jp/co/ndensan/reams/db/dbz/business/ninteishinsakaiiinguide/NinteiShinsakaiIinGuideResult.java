/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.ninteishinsakaiiinguide;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データEntiyのBusinessクラスです。
 *
 */
public class NinteiShinsakaiIinGuideResult {

    private final NinteiShinsakaiIinGuideEntity entity;

    /**
     * 審査会委員一覧情報Entiy作成処理
     *
     * @param entity 審査会委員一覧情報
     */
    public NinteiShinsakaiIinGuideResult(NinteiShinsakaiIinGuideEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員一覧情報"));
        this.entity = entity;
    }

    /**
     * コードを取得する。
     *
     * @return コード
     */
    public RString getコード() {
        return entity.getShinsakaiIinCode();
    }

    /**
     * 審査会委員名称を取得する。
     *
     * @return 審査会委員名称
     */
    public AtenaMeisho get審査会委員名称() {
        return entity.getShinsakaiIinName();
    }

    /**
     * 審査会委員名カナを取得する。
     *
     * @return 審査会委員名カナ
     */
    public AtenaKanaMeisho get審査会委員名カナ() {
        return entity.getShinsakaiIinKanaName();
    }

    /**
     * 性別を取得する。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 審査会委員資格を取得する。
     *
     * @return 審査会委員資格
     */
    public Code get審査会委員資格() {
        return entity.getShinsakaiIinShikaku();
    }
}
