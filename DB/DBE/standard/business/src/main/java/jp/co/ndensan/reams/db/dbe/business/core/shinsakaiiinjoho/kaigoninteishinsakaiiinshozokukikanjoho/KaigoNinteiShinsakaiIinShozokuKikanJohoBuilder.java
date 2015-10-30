/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KaigoNinteiShinsakaiIinShozokuKikanJoho}の編集を行うビルダークラスです。
 */
public class KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder {

    private final DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity;
    private final KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier id;

    /**
     * {@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}より{@link KaigoNinteiShinsakaiIinShozokuKikanJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity}
     * @param id {@link KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier}
     *
     */
    KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder(
            DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity,
            KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder}
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 主治医医療機関コードを設定します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return {@link KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder}
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder set主治医医療機関コード(RString 主治医医療機関コード) {
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        entity.setShujiiIryokikanCode(主治医医療機関コード);
        return this;
    }

    /**
     * 主治医コードを設定します。
     *
     * @param 主治医コード 主治医コード
     * @return {@link KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder}
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder set主治医コード(RString 主治医コード) {
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));
        entity.setShujiiCode(主治医コード);
        return this;
    }

    /**
     * 認定調査委託先コードを設定します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return {@link KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder}
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder set認定調査委託先コード(RString 認定調査委託先コード) {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        entity.setNinteichosaItakusakiCode(認定調査委託先コード);
        return this;
    }

    /**
     * 認定調査員コードを設定します。
     *
     * @param 認定調査員コード 認定調査員コード
     * @return {@link KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder}
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder set認定調査員コード(RString 認定調査員コード) {
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        entity.setNinteiChosainNo(認定調査員コード);
        return this;
    }

    /**
     * その他機関コードを設定します。
     *
     * @param その他機関コード その他機関コード
     * @return {@link KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder}
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder setその他機関コード(RString その他機関コード) {
        requireNonNull(その他機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("その他機関コード"));
        entity.setSonotaKikanCode(その他機関コード);
        return this;
    }

    /**
     * {@link KaigoNinteiShinsakaiIinShozokuKikanJoho}のインスタンスを生成します。
     *
     * @return {@link KaigoNinteiShinsakaiIinShozokuKikanJoho}のインスタンス
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJoho build() {
        return new KaigoNinteiShinsakaiIinShozokuKikanJoho(entity, id);
    }
}
