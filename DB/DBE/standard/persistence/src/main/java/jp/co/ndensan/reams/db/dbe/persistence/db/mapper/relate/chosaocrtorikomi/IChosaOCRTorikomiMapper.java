/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosaocrtorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosaocrtorikomi.ChosaOCRTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosaocrtorikomi.ChosaOCRTorikomiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会審査結果登録（OCR)のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1560-010 suguangjun
 */
public interface IChosaOCRTorikomiMapper {

    /**
     * 介護認定審査会審査結果登録（OCR)のヘッドエリアを取得します。
     *
     * @param parameter 介護認定審査会審査結果検索条件
     * @return List<ChosaOCRTorikomiRelateEntity>
     */
    List<ChosaOCRTorikomiRelateEntity> selectChosaOCRTorikomi(ChosaOCRTorikomiParameter parameter);

    /**
     * 介護認定審査会審査結果登録（OCR)の一覧エリアを取得します。
     *
     * @param parameter 介護認定審査会審査結果検索条件
     * @return List<ChosaOCRTorikomiRelateEntity>
     */
    List<ChosaOCRTorikomiRelateEntity> selectChosahyoTorikomiKekka(ChosaOCRTorikomiParameter parameter);

    /**
     * 申請書管理番号を取得します。
     *
     * @param parameter 介護認定審査会審査結果検索条件
     * @return 申請書管理番号
     */
    List<RString> selectShinseishoKanriNo(ChosaOCRTorikomiParameter parameter);
}
