package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoifupdate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoifupdate.YokaigoifUpdateMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoifupdate.YokaigoifUpdateRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 要介護認定IF更新のマッパーインタフェースです。
 *
 * @reamsid_L DBE-3000-310 jinjue
 */
public interface IYokaigoifUpdateRelateMapper {

    /**
     * 要介護認定インターフェース情報の必要な項目部分のみ編集してINSします。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 情報
     */
    List<YokaigoifUpdateRelateEntity> get情報_登録(YokaigoifUpdateMybitisParamter 申請書管理番号);

    /**
     * フェーズ番号が9の場合、要介護認定インターフェイス情報を更新するの情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 情報
     */
    List<YokaigoifUpdateRelateEntity> get情報_番号が9(YokaigoifUpdateMybitisParamter 申請書管理番号);

    /**
     * フェーズ番号が8の場合、要介護認定インターフェイス情報を更新するの情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 情報
     */
    List<YokaigoifUpdateRelateEntity> get情報_番号が8(YokaigoifUpdateMybitisParamter 申請書管理番号);

    /**
     * フェーズ番号が6の場合、要介護認定インターフェイス情報を更新するの情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 情報
     */
    List<YokaigoifUpdateRelateEntity> get情報_番号が6(YokaigoifUpdateMybitisParamter 申請書管理番号);

    /**
     * フェーズ番号が5の場合、要介護認定インターフェイス情報を更新するの情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 情報
     */
    List<YokaigoifUpdateRelateEntity> get情報_番号が5(YokaigoifUpdateMybitisParamter 申請書管理番号);

    /**
     * フェーズ番号が4の場合、要介護認定インターフェイス情報を更新するの情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 情報
     */
    List<YokaigoifUpdateRelateEntity> get情報_番号が4(YokaigoifUpdateMybitisParamter 申請書管理番号);

    /**
     * フェーズ番号が3の場合、要介護認定インターフェイス情報を更新するの情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 情報
     */
    List<YokaigoifUpdateRelateEntity> get情報_番号が3(YokaigoifUpdateMybitisParamter 申請書管理番号);

    /**
     * フェーズ番号が2の場合、要介護認定インターフェイス情報を更新するの情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 情報
     */
    List<YokaigoifUpdateRelateEntity> get情報_番号が2(YokaigoifUpdateMybitisParamter 申請書管理番号);

    /**
     * 要介護認定インターフェース情報の必要な項目部分のみ編集してINSします。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 情報
     */
    List<DbT4003YokaigoNinteiInterfaceEntity> getインターフェース情報(YokaigoifUpdateMybitisParamter 申請書管理番号);
}
