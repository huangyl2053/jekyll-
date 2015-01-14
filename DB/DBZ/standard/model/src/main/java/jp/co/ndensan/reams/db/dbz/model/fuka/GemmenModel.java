/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.fuka;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.code.kyotsu.HokenryoGemmenShurui;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.code.kyotsu.HokenryoGemmenTorikeshiShurui;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護賦課減免のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class GemmenModel implements Serializable {

    private DbT2004GemmenEntity entity;

    /**
     * コンストラクタです。
     */
    public GemmenModel() {
        entity = new DbT2004GemmenEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2004GemmenEntity
     */
    public GemmenModel(DbT2004GemmenEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2004GemmenEntityを返します。
     *
     * @return DbT2004GemmenEntity
     */
    public DbT2004GemmenEntity getEntity() {
        return entity;
    }

    /**
     * DbT2004GemmenEntityを設定します。
     *
     * @param entity DbT2004GemmenEntity
     */
    public void setEntity(DbT2004GemmenEntity entity) {
        this.entity = entity;
    }

    /**
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public ChoteiNendo get調定年度() {
        return new ChoteiNendo(entity.getChoteiNendo());
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FukaNendo get賦課年度() {
        return new FukaNendo(entity.getFukaNendo());
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return entity.getTsuchishoNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 減免申請年月日を返します。
     *
     * @return 減免申請年月日
     */
    public FlexibleDate get減免申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 減免決定年月日を返します。
     *
     * @return 減免決定年月日
     */
    public FlexibleDate get減免決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 減免取消年月日を返します。
     *
     * @return 減免取消年月日
     */
    public FlexibleDate get減免取消年月日() {
        return entity.getTorikeshiYMD();
    }

    /**
     * 減免状態区分を返します。
     *
     * @return 減免状態区分
     */
    public GemmenChoshuYuyoStateKubun get減免状態区分() {
        return GemmenChoshuYuyoStateKubun.toValue(entity.getJotaiKubun());
    }

    /**
     * 減免作成区分を返します。
     *
     * @return 減免作成区分
     */
    public GemmenChoshuYuyoSakuseiKubun get減免作成区分() {
        return GemmenChoshuYuyoSakuseiKubun.toValue(entity.getSakuseiKubun());
    }

    /**
     * 申請事由を返します。
     *
     * @return 申請事由
     */
    public RString get申請事由() {
        return entity.getShinseiJiyu();
    }

    /**
     * 減免種類を返します。
     *
     * @return 減免種類
     */
    public HokenryoGemmenShurui get減免種類() {
        return entity.getGemmenShuruiCode();
    }

    /**
     * 減免事由を返します。
     *
     * @return 減免事由
     */
    public RString get減免事由() {
        return entity.getGemmenJiyu();
    }

    /**
     * 減免取消種類を返します。
     *
     * @return 減免取消種類
     */
    public HokenryoGemmenTorikeshiShurui get減免取消種類() {
        return entity.getGemmenTorikeshiShuruiCode();
    }

    /**
     * 減免取消事由を返します。
     *
     * @return 減免取消事由
     */
    public RString get減免取消事由() {
        return entity.getGemmenTorikeshiJiyu();
    }

    /**
     * 申請減免額を返します。
     *
     * @return 申請減免額
     */
    public Decimal get申請減免額() {
        return entity.getShinseiGemmenGaku();
    }

    /**
     * 決定減免額を返します。
     *
     * @return 決定減免額
     */
    public Decimal get決定減免額() {
        return entity.getKetteiGemmenGaku();
    }

    /**
     * 取消減免額を返します。
     *
     * @return 取消減免額
     */
    public Decimal get取消減免額() {
        return entity.getTorikeshiGemmenGaku();
    }

    /**
     * 調定年度を設定します。
     *
     * @param 調定年度 調定年度
     */
    public void set調定年度(ChoteiNendo 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        entity.setChoteiNendo(調定年度.value());
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     */
    public void set賦課年度(FukaNendo 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度.value());
    }

    /**
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     */
    public void set通知書番号(TsuchishoNo 通知書番号) {
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        entity.setTsuchishoNo(通知書番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(RDateTime 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 減免申請年月日を設定します。
     *
     * @param 減免申請年月日 減免申請年月日
     */
    public void set減免申請年月日(FlexibleDate 減免申請年月日) {
        requireNonNull(減免申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("減免申請年月日"));
        entity.setShinseiYMD(減免申請年月日);
    }

    /**
     * 減免決定年月日を設定します。
     *
     * @param 減免決定年月日 減免決定年月日
     */
    public void set減免決定年月日(FlexibleDate 減免決定年月日) {
        requireNonNull(減免決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("減免決定年月日"));
        entity.setKetteiYMD(減免決定年月日);
    }

    /**
     * 減免取消年月日を設定します。
     *
     * @param 減免取消年月日 減免取消年月日
     */
    public void set減免取消年月日(FlexibleDate 減免取消年月日) {
        requireNonNull(減免取消年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("減免取消年月日"));
        entity.setTorikeshiYMD(減免取消年月日);
    }

    /**
     * 減免状態区分を設定します。
     *
     * @param 減免状態区分 減免状態区分
     */
    public void set減免状態区分(GemmenChoshuYuyoStateKubun 減免状態区分) {
        requireNonNull(減免状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("減免状態区分"));
        entity.setJotaiKubun(減免状態区分.code());
    }

    /**
     * 減免作成区分を設定します。
     *
     * @param 減免作成区分 減免作成区分
     */
    public void set減免作成区分(GemmenChoshuYuyoSakuseiKubun 減免作成区分) {
        requireNonNull(減免作成区分, UrSystemErrorMessages.値がnull.getReplacedMessage("減免作成区分"));
        entity.setSakuseiKubun(減免作成区分.code());
    }

    /**
     * 申請事由を設定します。
     *
     * @param 申請事由 申請事由
     */
    public void set申請事由(RString 申請事由) {
        requireNonNull(申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事由"));
        entity.setShinseiJiyu(申請事由);
    }

    /**
     * 減免種類を設定します。
     *
     * @param 減免種類 減免種類
     */
    public void set減免種類(HokenryoGemmenShurui 減免種類) {
        requireNonNull(減免種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免種類"));
        entity.setGemmenShuruiCode(減免種類);
    }

    /**
     * 減免事由を設定します。
     *
     * @param 減免事由 減免事由
     */
    public void set減免事由(RString 減免事由) {
        requireNonNull(減免事由, UrSystemErrorMessages.値がnull.getReplacedMessage("減免事由"));
        entity.setGemmenJiyu(減免事由);
    }

    /**
     * 減免取消種類を設定します。
     *
     * @param 減免取消種類 減免取消種類
     */
    public void set減免取消種類(HokenryoGemmenTorikeshiShurui 減免取消種類) {
        requireNonNull(減免取消種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免取消種類"));
        entity.setGemmenTorikeshiShuruiCode(減免取消種類);
    }

    /**
     * 減免取消事由を設定します。
     *
     * @param 減免取消事由 減免取消事由
     */
    public void set減免取消事由(RString 減免取消事由) {
        requireNonNull(減免取消事由, UrSystemErrorMessages.値がnull.getReplacedMessage("減免取消事由"));
        entity.setGemmenTorikeshiJiyu(減免取消事由);
    }

    /**
     * 申請減免額を設定します。
     *
     * @param 申請減免額 申請減免額
     */
    public void set申請減免額(Decimal 申請減免額) {
        requireNonNull(申請減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("申請減免額"));
        entity.setShinseiGemmenGaku(申請減免額);
    }

    /**
     * 決定減免額を設定します。
     *
     * @param 決定減免額 決定減免額
     */
    public void set決定減免額(Decimal 決定減免額) {
        requireNonNull(決定減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("決定減免額"));
        entity.setKetteiGemmenGaku(決定減免額);
    }

    /**
     * 取消減免額を設定します。
     *
     * @param 取消減免額 取消減免額
     */
    public void set取消減免額(Decimal 取消減免額) {
        requireNonNull(取消減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("取消減免額"));
        entity.setTorikeshiGemmenGaku(取消減免額);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
