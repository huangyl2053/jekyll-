/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 住宅改修理由書作成手数料請求明細のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class JutakuKaishuRiyushoTesuryoMeisaiModel implements Serializable {

    private DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity;

    /**
     * コンストラクタです。
     */
    public JutakuKaishuRiyushoTesuryoMeisaiModel() {
        entity = new DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity
     */
    public JutakuKaishuRiyushoTesuryoMeisaiModel(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityを返します。
     *
     * @return DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity
     */
    public DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityを設定します。
     *
     * @param entity DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity
     */
    public void setEntity(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * サービスコードを返します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード() {
        return entity.getServiceCode();
    }

    /**
     * 介護住宅改修事業者名称を返します。
     *
     * @return 介護住宅改修事業者名称
     */
    public AtenaMeisho get介護住宅改修事業者名称() {
        return entity.getJutakuKaishuJigyoshaMeisho();
    }

    /**
     * 介護住宅改修着工年月日を返します。
     *
     * @return 介護住宅改修着工年月日
     */
    public FlexibleDate get介護住宅改修着工年月日() {
        return entity.getJutakuKaishuChakkoYMD();
    }

    /**
     * 介護住宅改修住宅所有者を返します。
     *
     * @return 介護住宅改修住宅所有者
     */
    public AtenaMeisho get介護住宅改修住宅所有者() {
        return entity.getJutakuKaishuJushoShozaisha();
    }

    /**
     * 改修対象住宅住所を返します。
     *
     * @return 改修対象住宅住所
     */
    public RString get改修対象住宅住所() {
        return entity.getKaishuTaishoJutakuJusho();
    }

    /**
     * 改修内容_箇所及び規模を返します。
     *
     * @return 改修内容_箇所及び規模
     */
    public RString get改修内容_箇所及び規模() {
        return entity.getKaishuNaiyo_kasho_Kibo();
    }

    /**
     * 介護住宅改修理由書作成年月日を返します。
     *
     * @return 介護住宅改修理由書作成年月日
     */
    public FlexibleDate get介護住宅改修理由書作成年月日() {
        return entity.getRiyushoSakuseiYMD();
    }

    /**
     * 介護住宅改修理由書作成事業者番号を返します。
     *
     * @return 介護住宅改修理由書作成事業者番号
     */
    public JigyoshaNo get介護住宅改修理由書作成事業者番号() {
        return entity.getRiyushoSakuseiJigyoshaNo();
    }

    /**
     * 介護住宅改修理由書作成者名を返します。
     *
     * @return 介護住宅改修理由書作成者名
     */
    public AtenaMeisho get介護住宅改修理由書作成者名() {
        return entity.getRiyushoSakuseishaMei();
    }

    /**
     * 介護住宅改修理由書作成者資格を返します。
     *
     * @return 介護住宅改修理由書作成者資格
     */
    public RString get介護住宅改修理由書作成者資格() {
        return entity.getRiyushoSakuseishaShikaku();
    }

    /**
     * 介護住宅改修理由書作成申請年月日を返します。
     *
     * @return 介護住宅改修理由書作成申請年月日
     */
    public FlexibleDate get介護住宅改修理由書作成申請年月日() {
        return entity.getRiyushoSakuseiShinseiYMD();
    }

    /**
     * 介護住宅改修理由書作成受付年月日を返します。
     *
     * @return 介護住宅改修理由書作成受付年月日
     */
    public FlexibleDate get介護住宅改修理由書作成受付年月日() {
        return entity.getRiyushoSakuseiUketsukeYMD();
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * サービスコードを設定します。
     *
     * @param サービスコード サービスコード
     */
    public void setサービスコード(ServiceCode サービスコード) {
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        entity.setServiceCode(サービスコード);
    }

    /**
     * 介護住宅改修事業者名称を設定します。
     *
     * @param 介護住宅改修事業者名称 介護住宅改修事業者名称
     */
    public void set介護住宅改修事業者名称(AtenaMeisho 介護住宅改修事業者名称) {
        requireNonNull(介護住宅改修事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修事業者名称"));
        entity.setJutakuKaishuJigyoshaMeisho(介護住宅改修事業者名称);
    }

    /**
     * 介護住宅改修着工年月日を設定します。
     *
     * @param 介護住宅改修着工年月日 介護住宅改修着工年月日
     */
    public void set介護住宅改修着工年月日(FlexibleDate 介護住宅改修着工年月日) {
        requireNonNull(介護住宅改修着工年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修着工年月日"));
        entity.setJutakuKaishuChakkoYMD(介護住宅改修着工年月日);
    }

    /**
     * 介護住宅改修住宅所有者を設定します。
     *
     * @param 介護住宅改修住宅所有者 介護住宅改修住宅所有者
     */
    public void set介護住宅改修住宅所有者(AtenaMeisho 介護住宅改修住宅所有者) {
        requireNonNull(介護住宅改修住宅所有者, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修住宅所有者"));
        entity.setJutakuKaishuJushoShozaisha(介護住宅改修住宅所有者);
    }

    /**
     * 改修対象住宅住所を設定します。
     *
     * @param 改修対象住宅住所 改修対象住宅住所
     */
    public void set改修対象住宅住所(RString 改修対象住宅住所) {
        requireNonNull(改修対象住宅住所, UrSystemErrorMessages.値がnull.getReplacedMessage("改修対象住宅住所"));
        entity.setKaishuTaishoJutakuJusho(改修対象住宅住所);
    }

    /**
     * 改修内容_箇所及び規模を設定します。
     *
     * @param 改修内容_箇所及び規模 改修内容_箇所及び規模
     */
    public void set改修内容_箇所及び規模(RString 改修内容_箇所及び規模) {
        requireNonNull(改修内容_箇所及び規模, UrSystemErrorMessages.値がnull.getReplacedMessage("改修内容_箇所及び規模"));
        entity.setKaishuNaiyo_kasho_Kibo(改修内容_箇所及び規模);
    }

    /**
     * 介護住宅改修理由書作成年月日を設定します。
     *
     * @param 介護住宅改修理由書作成年月日 介護住宅改修理由書作成年月日
     */
    public void set介護住宅改修理由書作成年月日(FlexibleDate 介護住宅改修理由書作成年月日) {
        requireNonNull(介護住宅改修理由書作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成年月日"));
        entity.setRiyushoSakuseiYMD(介護住宅改修理由書作成年月日);
    }

    /**
     * 介護住宅改修理由書作成事業者番号を設定します。
     *
     * @param 介護住宅改修理由書作成事業者番号 介護住宅改修理由書作成事業者番号
     */
    public void set介護住宅改修理由書作成事業者番号(JigyoshaNo 介護住宅改修理由書作成事業者番号) {
        requireNonNull(介護住宅改修理由書作成事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成事業者番号"));
        entity.setRiyushoSakuseiJigyoshaNo(介護住宅改修理由書作成事業者番号);
    }

    /**
     * 介護住宅改修理由書作成者名を設定します。
     *
     * @param 介護住宅改修理由書作成者名 介護住宅改修理由書作成者名
     */
    public void set介護住宅改修理由書作成者名(AtenaMeisho 介護住宅改修理由書作成者名) {
        requireNonNull(介護住宅改修理由書作成者名, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成者名"));
        entity.setRiyushoSakuseishaMei(介護住宅改修理由書作成者名);
    }

    /**
     * 介護住宅改修理由書作成者資格を設定します。
     *
     * @param 介護住宅改修理由書作成者資格 介護住宅改修理由書作成者資格
     */
    public void set介護住宅改修理由書作成者資格(RString 介護住宅改修理由書作成者資格) {
        requireNonNull(介護住宅改修理由書作成者資格, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成者資格"));
        entity.setRiyushoSakuseishaShikaku(介護住宅改修理由書作成者資格);
    }

    /**
     * 介護住宅改修理由書作成申請年月日を設定します。
     *
     * @param 介護住宅改修理由書作成申請年月日 介護住宅改修理由書作成申請年月日
     */
    public void set介護住宅改修理由書作成申請年月日(FlexibleDate 介護住宅改修理由書作成申請年月日) {
        requireNonNull(介護住宅改修理由書作成申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成申請年月日"));
        entity.setRiyushoSakuseiShinseiYMD(介護住宅改修理由書作成申請年月日);
    }

    /**
     * 介護住宅改修理由書作成受付年月日を設定します。
     *
     * @param 介護住宅改修理由書作成受付年月日 介護住宅改修理由書作成受付年月日
     */
    public void set介護住宅改修理由書作成受付年月日(FlexibleDate 介護住宅改修理由書作成受付年月日) {
        requireNonNull(介護住宅改修理由書作成受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成受付年月日"));
        entity.setRiyushoSakuseiUketsukeYMD(介護住宅改修理由書作成受付年月日);
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
