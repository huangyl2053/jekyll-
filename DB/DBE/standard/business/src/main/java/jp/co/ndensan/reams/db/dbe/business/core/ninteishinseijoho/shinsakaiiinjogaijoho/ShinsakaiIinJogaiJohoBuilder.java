/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiiinjogaijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5590ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinsakaiIinJogaiJoho}の編集を行うビルダークラスです。
 */
public class ShinsakaiIinJogaiJohoBuilder {

    private final DbT5590ShinsakaiIinJogaiJohoEntity entity;
    private final ShinsakaiIinJogaiJohoIdentifier id;

    /**
     * {@link DbT5590ShinsakaiIinJogaiJohoEntity}より{@link ShinsakaiIinJogaiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5590ShinsakaiIinJogaiJohoEntity}
     * @param id {@link ShinsakaiIinJogaiJohoIdentifier}
     *
     */
    ShinsakaiIinJogaiJohoBuilder(
            DbT5590ShinsakaiIinJogaiJohoEntity entity,
            ShinsakaiIinJogaiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link ShinsakaiIinJogaiJohoBuilder}
     */
    public ShinsakaiIinJogaiJohoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link ShinsakaiIinJogaiJohoBuilder}
     */
    public ShinsakaiIinJogaiJohoBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
        return this;
    }

    /**
     * 除外対象審査会委員コードを設定します。
     *
     * @param 除外対象審査会委員コード 除外対象審査会委員コード
     * @return {@link ShinsakaiIinJogaiJohoBuilder}
     */
    public ShinsakaiIinJogaiJohoBuilder set除外対象審査会委員コード(RString 除外対象審査会委員コード) {
        requireNonNull(除外対象審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("除外対象審査会委員コード"));
        entity.setJogaiTaishoShinsakaiIinCode(除外対象審査会委員コード);
        return this;
    }

    /**
     * {@link ShinsakaiIinJogaiJoho}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiIinJogaiJoho}のインスタンス
     */
    public ShinsakaiIinJogaiJoho build() {
        return new ShinsakaiIinJogaiJoho(entity, id);
    }
}
