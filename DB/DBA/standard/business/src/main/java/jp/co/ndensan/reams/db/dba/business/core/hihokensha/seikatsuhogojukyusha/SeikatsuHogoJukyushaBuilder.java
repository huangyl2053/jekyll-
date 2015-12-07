/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogojukyusha;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShurui;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShuruiBuilder;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShuruiIdentifier;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogoteishikikan.SeikatsuHogoTeishikikan;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogoteishikikan.SeikatsuHogoTeishikikanIdentifier;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.KaigoRyoDairiNofuKubun;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.KyugoShisetsuNyuTaishoKubun;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link SeikatsuHogoJukyusha}の編集を行うビルダークラスです。
 */
public class SeikatsuHogoJukyushaBuilder {

    private final UrT0508SeikatsuHogoJukyushaEntity entity;
    private final SeikatsuHogoJukyushaIdentifier id;
    private final Models<SeikatsuHogoFujoShuruiIdentifier, SeikatsuHogoFujoShurui> seikatsuHogoFujoShurui;
    private final Models<SeikatsuHogoTeishikikanIdentifier, SeikatsuHogoTeishikikan> seikatsuHogoTeishikikan;

    /**
     * {@link UrT0508SeikatsuHogoJukyushaEntity}より{@link SeikatsuHogoJukyusha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link UrT0508SeikatsuHogoJukyushaEntity}
     * @param id {@link SeikatsuHogoJukyushaIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    SeikatsuHogoJukyushaBuilder(
            UrT0508SeikatsuHogoJukyushaEntity entity,
            SeikatsuHogoJukyushaIdentifier id,
            Models<SeikatsuHogoFujoShuruiIdentifier, SeikatsuHogoFujoShurui> seikatsuHogoFujoShurui,
            Models<SeikatsuHogoTeishikikanIdentifier, SeikatsuHogoTeishikikan> seikatsuHogoTeishikikan
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.seikatsuHogoFujoShurui = seikatsuHogoFujoShurui.clone();
        this.seikatsuHogoTeishikikan = seikatsuHogoTeishikikan.clone();

    }

    /**
     * 受給廃止日を設定します。
     *
     * @param 受給廃止日 受給廃止日
     * @return {@link SeikatsuHogoJukyushaBuilder}
     */
    public SeikatsuHogoJukyushaBuilder set受給廃止日(FlexibleDate 受給廃止日) {
        requireNonNull(受給廃止日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給廃止日"));
        entity.setJukyuHaishiYMD(受給廃止日);
        return this;
    }

    /**
     * 受給者番号を設定します。
     *
     * @param 受給者番号 受給者番号
     * @return {@link SeikatsuHogoJukyushaBuilder}
     */
    public SeikatsuHogoJukyushaBuilder set受給者番号(RString 受給者番号) {
        requireNonNull(受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者番号"));
        entity.setJukyushaNo(受給者番号);
        return this;
    }

    /**
     * 介護保険料代理納付区分を設定します。
     *
     * @param 介護保険料代理納付区分 介護保険料代理納付区分
     * @return {@link SeikatsuHogoJukyushaBuilder}
     */
    public SeikatsuHogoJukyushaBuilder set介護保険料代理納付区分(KaigoRyoDairiNofuKubun 介護保険料代理納付区分) {
        requireNonNull(介護保険料代理納付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険料代理納付区分"));
        entity.setKaigoRyoDairiNofuKubun(介護保険料代理納付区分);
        return this;
    }

    /**
     * 介護保険料代理納付年月を設定します。
     *
     * @param 介護保険料代理納付年月 介護保険料代理納付年月
     * @return {@link SeikatsuHogoJukyushaBuilder}
     */
    public SeikatsuHogoJukyushaBuilder set介護保険料代理納付年月(FlexibleYearMonth 介護保険料代理納付年月) {
        requireNonNull(介護保険料代理納付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険料代理納付年月"));
        entity.setKaigoRyoDairiNofuYM(介護保険料代理納付年月);
        return this;
    }

    /**
     * 救護施設入退所区分を設定します。
     *
     * @param 救護施設入退所区分 救護施設入退所区分
     * @return {@link SeikatsuHogoJukyushaBuilder}
     */
    public SeikatsuHogoJukyushaBuilder set救護施設入退所区分(KyugoShisetsuNyuTaishoKubun 救護施設入退所区分) {
        requireNonNull(救護施設入退所区分, UrSystemErrorMessages.値がnull.getReplacedMessage("救護施設入退所区分"));
        entity.setKyugoShisetsuNyuTaishoKubun(救護施設入退所区分);
        return this;
    }

    /**
     * 救護施設入退所日を設定します。
     *
     * @param 救護施設入退所日 救護施設入退所日
     * @return {@link SeikatsuHogoJukyushaBuilder}
     */
    public SeikatsuHogoJukyushaBuilder set救護施設入退所日(FlexibleDate 救護施設入退所日) {
        requireNonNull(救護施設入退所日, UrSystemErrorMessages.値がnull.getReplacedMessage("救護施設入退所日"));
        entity.setKyugoShisetsuNyutaishoYMD(救護施設入退所日);
        return this;
    }

    /**
     * 生活保護扶助種類情報のキー情報について判定します。<br>
     * 生活保護受給者情報に関連できる生活保護扶助種類情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は生活保護扶助種類情報リストに生活保護扶助種類情報{@link SeikatsuHogoFujoShurui}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 生活保護扶助種類情報 {@link SeikatsuHogoFujoShurui}
     * @return {@link SeikatsuHogoFujoShuruiBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public SeikatsuHogoJukyushaBuilder setSeikatsuHogoFujoShurui(SeikatsuHogoFujoShurui 生活保護扶助種類情報) {
        if (hasSeikatsuHogoFujoShuruiIdentifier(生活保護扶助種類情報.identifier())) {
            seikatsuHogoFujoShurui.add(生活保護扶助種類情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSeikatsuHogoFujoShuruiIdentifier(SeikatsuHogoFujoShuruiIdentifier 生活保護扶助種類情報識別子) {
        return (id.get識別コード().equals(生活保護扶助種類情報識別子.get識別コード())
                && id.get業務コード().equals(生活保護扶助種類情報識別子.get業務コード())
                && id.get受給開始日().equals(生活保護扶助種類情報識別子.get受給開始日()));
    }

    /**
     * 生活保護停止期間情報のキー情報について判定します。<br>
     * 生活保護受給者情報に関連できる生活保護停止期間情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は生活保護停止期間情報リストに生活保護停止期間情報{@link SeikatsuHogoTeishikikan}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 生活保護停止期間情報 {@link SeikatsuHogoTeishikikan}
     * @return Builder
     * @throws IllegalStateException キーが一致しない場合
     */
    public SeikatsuHogoJukyushaBuilder setSeikatsuHogoTeishikikan(SeikatsuHogoTeishikikan 生活保護停止期間情報) {
        if (hasSeikatsuHogoTeishikikanIdentifier(生活保護停止期間情報.identifier())) {
            seikatsuHogoTeishikikan.add(生活保護停止期間情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSeikatsuHogoTeishikikanIdentifier(SeikatsuHogoTeishikikanIdentifier 生活保護停止期間情報識別子) {
        return (id.get識別コード().equals(生活保護停止期間情報識別子.get識別コード())
                && id.get業務コード().equals(生活保護停止期間情報識別子.get業務コード())
                && id.get受給開始日().equals(生活保護停止期間情報識別子.get受給開始日()));
    }

    /**
     * {@link SeikatsuHogoJukyusha}のインスタンスを生成します。
     *
     * @return {@link SeikatsuHogoJukyusha}のインスタンス
     */
    public SeikatsuHogoJukyusha build() {
        return new SeikatsuHogoJukyusha(entity, id, seikatsuHogoFujoShurui, seikatsuHogoTeishikikan);
    }
}
