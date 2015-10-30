/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinsakaiKaisaiKekkaJoho}の編集を行うビルダークラスです。
 */
public class ShinsakaiKaisaiKekkaJohoBuilder {

    private final DbT5511ShinsakaiKaisaiKekkaJohoEntity entity;
    private final ShinsakaiKaisaiKekkaJohoIdentifier id;

    /**
     * {@link DbT5511ShinsakaiKaisaiKekkaJohoEntity}より{@link ShinsakaiKaisaiKekkaJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5511ShinsakaiKaisaiKekkaJohoEntity}
     * @param id {@link ShinsakaiKaisaiKekkaJohoIdentifier}
     *
     */
    ShinsakaiKaisaiKekkaJohoBuilder(
            DbT5511ShinsakaiKaisaiKekkaJohoEntity entity,
            ShinsakaiKaisaiKekkaJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 合議体番号を設定します。
     *
     * @param 合議体番号 合議体番号
     * @return {@link ShinsakaiKaisaiKekkaJohoBuilder}
     */
    public ShinsakaiKaisaiKekkaJohoBuilder set合議体番号(int 合議体番号) {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));
        entity.setGogitaiNo(合議体番号);
        return this;
    }

    /**
     * 介護認定審査会開催年月日を設定します。
     *
     * @param 介護認定審査会開催年月日 介護認定審査会開催年月日
     * @return {@link ShinsakaiKaisaiKekkaJohoBuilder}
     */
    public ShinsakaiKaisaiKekkaJohoBuilder set介護認定審査会開催年月日(FlexibleDate 介護認定審査会開催年月日) {
        requireNonNull(介護認定審査会開催年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催年月日"));
        entity.setShinsakaiKaisaiYMD(介護認定審査会開催年月日);
        return this;
    }

    /**
     * 介護認定審査会開始時刻を設定します。
     *
     * @param 介護認定審査会開始時刻 介護認定審査会開始時刻
     * @return {@link ShinsakaiKaisaiKekkaJohoBuilder}
     */
    public ShinsakaiKaisaiKekkaJohoBuilder set介護認定審査会開始時刻(RString 介護認定審査会開始時刻) {
        requireNonNull(介護認定審査会開始時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開始時刻"));
        entity.setShinsakaiKaishiTime(介護認定審査会開始時刻);
        return this;
    }

    /**
     * 介護認定審査会終了時刻を設定します。
     *
     * @param 介護認定審査会終了時刻 介護認定審査会終了時刻
     * @return {@link ShinsakaiKaisaiKekkaJohoBuilder}
     */
    public ShinsakaiKaisaiKekkaJohoBuilder set介護認定審査会終了時刻(RString 介護認定審査会終了時刻) {
        requireNonNull(介護認定審査会終了時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会終了時刻"));
        entity.setShinsakaiShuryoTime(介護認定審査会終了時刻);
        return this;
    }

    /**
     * 介護認定審査会開催場所コードを設定します。
     *
     * @param 介護認定審査会開催場所コード 介護認定審査会開催場所コード
     * @return {@link ShinsakaiKaisaiKekkaJohoBuilder}
     */
    public ShinsakaiKaisaiKekkaJohoBuilder set介護認定審査会開催場所コード(RString 介護認定審査会開催場所コード) {
        requireNonNull(介護認定審査会開催場所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所コード"));
        entity.setShinsakaiKaisaiBashoCode(介護認定審査会開催場所コード);
        return this;
    }

    /**
     * 所要時間合計を設定します。
     *
     * @param 所要時間合計 所要時間合計
     * @return {@link ShinsakaiKaisaiKekkaJohoBuilder}
     */
    public ShinsakaiKaisaiKekkaJohoBuilder set所要時間合計(int 所要時間合計) {
        requireNonNull(所要時間合計, UrSystemErrorMessages.値がnull.getReplacedMessage("所要時間合計"));
        entity.setShoyoJikanGokei(所要時間合計);
        return this;
    }

    /**
     * 介護認定審査会実施人数を設定します。
     *
     * @param 介護認定審査会実施人数 介護認定審査会実施人数
     * @return {@link ShinsakaiKaisaiKekkaJohoBuilder}
     */
    public ShinsakaiKaisaiKekkaJohoBuilder set介護認定審査会実施人数(int 介護認定審査会実施人数) {
        requireNonNull(介護認定審査会実施人数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会実施人数"));
        entity.setShinsakaiJisshiNinzu(介護認定審査会実施人数);
        return this;
    }

    /**
     * {@link ShinsakaiKaisaiKekkaJoho}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiKaisaiKekkaJoho}のインスタンス
     */
    public ShinsakaiKaisaiKekkaJoho build() {
        return new ShinsakaiKaisaiKekkaJoho(entity, id);
    }
}
