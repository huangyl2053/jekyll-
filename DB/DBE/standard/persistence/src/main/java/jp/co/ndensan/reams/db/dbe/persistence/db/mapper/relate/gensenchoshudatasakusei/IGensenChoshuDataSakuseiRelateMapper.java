/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gensenchoshudatasakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.gensenchoshudatasakusei.GensenChoshuMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gensenchoshudatasakusei.GensenChoshuRelateEntity;

/**
 * 「源泉徴収データ作成」のMapperです。
 *
 * @reamsid_L DBE-2000-010 jinjue
 */
public interface IGensenChoshuDataSakuseiRelateMapper {

    /**
     * 「源泉徴収データ作成」データの取得です。
     *
     * @param gensenChoshuparam 「源泉徴収データ作成のparameter
     * @return データ情報
     */
    List<GensenChoshuRelateEntity> getデータ情報(GensenChoshuMapperParameter gensenChoshuparam);
}
