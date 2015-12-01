/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiWariateIinJoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaiiinjoho.ShinsakaiIinJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link GogitaiWariateIinJoho}の編集を行うビルダークラスです。
 */
public class GogitaiWariateIinJohoBuilder {

    private final DbT5593GogitaiWariateIinJohoEntity entity;
    private final GogitaiWariateIinJohoIdentifier id;
    private final Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> shinsakaiIinJoho;

    /**
     * {@link DbT5593GogitaiWariateIinJohoEntity}より{@link GogitaiWariateIinJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5593GogitaiWariateIinJohoEntity}
     * @param id {@link GogitaiWariateIinJohoIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    GogitaiWariateIinJohoBuilder(
            DbT5593GogitaiWariateIinJohoEntity entity,
            GogitaiWariateIinJohoIdentifier id,
            Models<ShinsakaiIinJohoIdentifier, ShinsakaiIinJoho> shinsakaiIinJoho
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.shinsakaiIinJoho = shinsakaiIinJoho.clone();

    }

    /**
     * 合議体有効期間終了年月日を設定します。
     *
     * @param 合議体有効期間終了年月日 合議体有効期間終了年月日
     * @return {@link GogitaiWariateIinJohoBuilder}
     */
    public GogitaiWariateIinJohoBuilder set合議体有効期間終了年月日(FlexibleDate 合議体有効期間終了年月日) {
        requireNonNull(合議体有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体有効期間終了年月日"));
        entity.setGogitaiYukoKikanShuryoYMD(合議体有効期間終了年月日);
        return this;
    }

    /**
     * 合議体長区分コードを設定します。
     *
     * @param 合議体長区分コード 合議体長区分コード
     * @return {@link GogitaiWariateIinJohoBuilder}
     */
    public GogitaiWariateIinJohoBuilder set合議体長区分コード(Code 合議体長区分コード) {
        requireNonNull(合議体長区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体長区分コード"));
        entity.setGogitaichoKubunCode(合議体長区分コード);
        return this;
    }

    /**
     * 補欠を設定します。
     *
     * @param 補欠 補欠
     * @return {@link GogitaiWariateIinJohoBuilder}
     */
    public GogitaiWariateIinJohoBuilder set補欠(boolean 補欠) {
        requireNonNull(補欠, UrSystemErrorMessages.値がnull.getReplacedMessage("補欠"));
        entity.setSubstituteFlag(補欠);
        return this;
    }

    /**
     * 介護認定審査会委員情報のキー情報について判定します。<br>
     * 介護認定審査会委員情報に関連できる介護認定審査会委員情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護認定審査会委員情報リストに介護認定審査会委員情報{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護認定審査会委員情報 {@link ShinsakaiIinJoho}
     * @return {@link GogitaiWariateIinJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public GogitaiWariateIinJohoBuilder setSeishinTechoNini(ShinsakaiIinJoho 介護認定審査会委員情報) {
        if (hasSameIdentifier(介護認定審査会委員情報.identifier())) {
            shinsakaiIinJoho.add(介護認定審査会委員情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(ShinsakaiIinJohoIdentifier 介護認定審査会委員情報識別子) {
        return id.get介護認定審査会委員コード().equals(介護認定審査会委員情報識別子.get介護認定審査会委員コード());
    }

    /**
     * {@link GogitaiWariateIinJoho}のインスタンスを生成します。
     *
     * @return {@link GogitaiWariateIinJoho}のインスタンス
     */
    public GogitaiWariateIinJoho build() {
        return new GogitaiWariateIinJoho(entity, id, shinsakaiIinJoho);
    }
}
