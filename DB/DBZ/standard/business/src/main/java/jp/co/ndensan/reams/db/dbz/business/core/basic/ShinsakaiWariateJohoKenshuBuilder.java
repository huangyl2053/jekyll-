/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5504ShinsakaiWariateJohoKenshuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3213
 */
public class ShinsakaiWariateJohoKenshuBuilder {
    
    private final DbT5504ShinsakaiWariateJohoKenshuEntity entity;
    private final ShinsakaiWariateJohoKenshuIdentifier id;

    /**
     * {@link DbT5121ShinseiRirekiJohoEntity}より{@link ShinseiRirekiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5121ShinseiRirekiJohoEntity}
     * @param id {@link ShinseiRirekiJohoIdentifier}
     *
     */
    ShinsakaiWariateJohoKenshuBuilder(
            DbT5504ShinsakaiWariateJohoKenshuEntity entity,
            ShinsakaiWariateJohoKenshuIdentifier id) {
        this.entity = entity.clone();
        this.id = id;
    }
    
    /**
     * 介護認定審査会開催番号をセット
     * 
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return {@link ShinsakaiWariateJohoKenshuBuilder}
     */
    public ShinsakaiWariateJohoKenshuBuilder set介護認定審査会開催番号(RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        return this;
    }
    
    /**
     * 申請書管理番号をセットをセット
     * 
     * @param 申請書管理番号 申請書管理番号
     * @return {@link ShinsakaiWariateJohoKenshuBuilder}
     */
    public ShinsakaiWariateJohoKenshuBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }
    
    /**
     * 介護認定審査会開催年月日をセット
     * 
     * @param 介護認定審査会開催年月日 介護認定審査会開催年月日
     * @return {@link ShinsakaiWariateJohoKenshuBuilder}
     */
    public ShinsakaiWariateJohoKenshuBuilder set介護認定審査会開催年月日(FlexibleDate 介護認定審査会開催年月日) {
        requireNonNull(介護認定審査会開催年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催年月日"));
        entity.setShinsakaiKaisaiYMD(介護認定審査会開催年月日);
        return this;
    }
    
    /**
     * 介護認定審査会割当年月日をセット
     * 
     * @param 介護認定審査会割当年月日 介護認定審査会割当年月日
     * @return {@link ShinsakaiWariateJohoKenshuBuilder}
     */
    public ShinsakaiWariateJohoKenshuBuilder set介護認定審査会割当年月日(FlexibleDate 介護認定審査会割当年月日) {
        requireNonNull(介護認定審査会割当年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当年月日"));
        entity.setShinsakaiWariateYMD(介護認定審査会割当年月日);
        return this;
    }
    
    /**
     * 介護認定審査会審査順をセット
     * 
     * @param 介護認定審査会審査順 介護認定審査会審査順
     * @return {@link ShinsakaiWariateJohoKenshuBuilder}
     */
    public ShinsakaiWariateJohoKenshuBuilder set介護認定審査会審査順(int 介護認定審査会審査順) {
        requireNonNull(介護認定審査会審査順, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会審査順"));
        entity.setShinsakaiOrder(介護認定審査会審査順);
        return this;
    }
    
    /**
     * 介護認定審査会審査順確定フラグをセット
     * 
     * @param 介護認定審査会審査順確定フラグ 介護認定審査会審査順確定フラグ
     * @return {@link ShinsakaiWariateJohoKenshuBuilder}
     */
    public ShinsakaiWariateJohoKenshuBuilder set介護認定審査会審査順確定フラグ(boolean 介護認定審査会審査順確定フラグ) {
        requireNonNull(介護認定審査会審査順確定フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会審査順確定フラグ"));
        entity.setShinsakaiOrderKakuteiFlag(介護認定審査会審査順確定フラグ);
        return this;
    }
    
    /**
     * 審査会自動割付フラグをセット
     * 
     * @param 審査会自動割付フラグ 審査会自動割付フラグ
     * @return {@link ShinsakaiWariateJohoKenshuBuilder}
     */
    public ShinsakaiWariateJohoKenshuBuilder set審査会自動割付フラグ(boolean 審査会自動割付フラグ) {
        requireNonNull(審査会自動割付フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会自動割付フラグ"));
        entity.setShinsakaiJidoWaritsukeFlag(審査会自動割付フラグ);
        return this;
    }
    
    /**
     * 審査会資料作成年月日をセット
     * 
     * @param 審査会資料作成年月日 審査会資料作成年月日
     * @return {@link ShinsakaiWariateJohoKenshuBuilder}
     */
    public ShinsakaiWariateJohoKenshuBuilder set審査会資料作成年月日(FlexibleDate 審査会資料作成年月日) {
        requireNonNull(審査会資料作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会資料作成年月日"));
        entity.setShinsakaiShiryoSakuseiYMD(審査会資料作成年月日);
        return this;
    }
    
    /**
     * 審査会資料送付年月日をセット
     * 
     * @param 審査会資料送付年月日 審査会資料送付年月日
     * @return {@link ShinsakaiWariateJohoKenshuBuilder}
     */
    public ShinsakaiWariateJohoKenshuBuilder set審査会資料送付年月日(FlexibleDate 審査会資料送付年月日) {
        requireNonNull(審査会資料送付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会資料送付年月日"));
        entity.setShinsakaiShiryoSofuYMD(審査会資料送付年月日);
        return this;
    }
    
    /**
     * 判定結果コードをセット
     * 
     * @param 判定結果コード 判定結果コード
     * @return {@link ShinsakaiWariateJohoKenshuBuilder}
     */
    public ShinsakaiWariateJohoKenshuBuilder set判定結果コード(Code 判定結果コード) {
        requireNonNull(判定結果コード, UrSystemErrorMessages.値がnull.getReplacedMessage("判定結果コード"));
        entity.setHanteiKekkaCode(判定結果コード);
        return this;
    }

    /**
     * {@link ShinseiRirekiJoho}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiWariateJohoKenshu}のインスタンス
     */
    public ShinsakaiWariateJohoKenshu build() {
        return new ShinsakaiWariateJohoKenshu(entity, id);
    }
    
}
