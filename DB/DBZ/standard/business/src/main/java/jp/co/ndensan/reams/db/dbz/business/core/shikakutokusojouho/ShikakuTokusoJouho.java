/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shikakutokusojouho;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakutokusojouho.ShikakuTokusouJouhoRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 資格情報一覧ガイドにＤＢから検索するデータが表示するクラスです。
 */
public class ShikakuTokusoJouho {

    private final ShikakuTokusouJouhoRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 資格得喪Entity
     */
    public ShikakuTokusoJouho(ShikakuTokusouJouhoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 資格取得年月日を取得します。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate get資格取得年月日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得届出年月日を取得します。
     *
     * @return 資格取得届出年月日
     */
    public FlexibleDate get資格取得届出年月日() {
        return entity.getShikakuShutokuTodokedeYMD();
    }

    /**
     * 取得事由コードを取得します。
     *
     * @return 取得事由コード
     */
    public RString get取得事由コード() {
        return entity.getShikakuShutokuJiyuCode();
    }

    /**
     * 被保険者区分コードを取得します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.getHihokennshaKubunCode();
    }

    /**
     * 資格喪失年月日を取得します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失届出年月日を取得します。
     *
     * @return 資格喪失届出年月日
     */
    public FlexibleDate get資格喪失届出年月日() {
        return entity.getShikakuSoshitsuTodokedeYMD();
    }

    /**
     * 喪失事由コードを取得します。
     *
     * @return 喪失事由コード
     */
    public RString get喪失事由コード() {
        return entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 住所地特例フラグを取得します。
     *
     * @return 住所地特例フラグ
     */
    public RString get住所地特例フラグ() {
        return entity.getJushochiTokureiFlag();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 広住特措置元市町村コードを取得します。
     *
     * @return 広住特措置元市町村コード
     */
    public LasdecCode get広住特措置元市町村コード() {
        return entity.getShichosonCode2();
    }

    /**
     * 措置元保険者を取得します。
     *
     * @return 措置元保険者
     */
    public RString get措置元保険者() {
        return entity.getShichosonMeisho2();
    }

    /**
     * 旧市町村コードを取得します。
     *
     * @return 旧市町村コード
     */
    public LasdecCode get旧市町村コード() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 旧市町村名称を取得します。
     *
     * @return 旧市町村名称
     */
    public RString get旧市町村名称() {
        return entity.getKyuShichosonMeisho();
    }

    /**
     * 旧市町村名称を取得します。
     *
     * @return 旧市町村名称
     */
    public RDateTime get処理日時() {
        return entity.getLastUpdateTimestamp();
    }
     /**
     * 旧市町村名称を取得します。
     *
     * @return 旧市町村名称
     */
    public RString get単一広域区分() {
        return entity.getTanIchi();
    }
}
