/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.jushotitokure;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例の一覧データを扱います。
 *
 */
public class JushotiTokureiBusiness implements Serializable {

    private final DbT1001HihokenshaDaichoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 被保険者台帳管理Entity
     */
    public JushotiTokureiBusiness(DbT1001HihokenshaDaichoEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保番号を取得します。
     *
     * @return 被保番号
     */
    public HihokenshaNo get被保番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 異動日を取得します。
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return entity.getIdoYMD();
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public RString get枝番() {
        return entity.getEdaNo();
    }

    /**
     * 適用日を取得します。
     *
     * @return 適用日
     */
    public FlexibleDate get適用日() {
        return entity.getJushochitokureiTekiyoYMD();
    }

    /**
     * 適用届出日を取得します。
     *
     * @return 適用届出日
     */
    public FlexibleDate get適用届出日() {
        return entity.getJushochitokureiTekiyoTodokedeYMD();
    }

    /**
     * 適用事由コードを取得します。
     *
     * @return 適用事由コード
     */
    public KaigoShikakuJutokuTekiyoJiyu get適用事由コード() {
        return entity.getJushochitokureiTekiyoJiyuCode();
    }

    /**
     * 解除日を取得します。
     *
     * @return 解除日
     */
    public FlexibleDate get解除日() {
        return entity.getJushochitokureiKaijoYMD();
    }

    /**
     * 解除届出日を取得します。
     *
     * @return 解除届出日
     */
    public FlexibleDate get解除届出日() {
        return entity.getJushochitokureiKaijoTodokedeYMD();
    }

    /**
     * 解除事由コードを取得します。
     *
     * @return 解除事由コード
     */
    public KaigoShikakuJutokuKaijoJiyu get解除事由コード() {
        return entity.getJushochitokureiKaijoJiyuCode();
    }

    /**
     * 処理日時を取得します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return entity.getLastUpdateTimestamp();
    }

    /**
     * 住特区分を取得します。
     *
     * @return 住特区分
     */
    public RString get住特区分() {
        return entity.getJushochiTokureiFlag();
    }

}
