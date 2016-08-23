/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.jizenshinsakekka;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.jizenshinsakekka.JizenShinsakekkaMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.jizenshinsakekka.JizenShinsaKekkaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 事前審査結果登録データ作成インタフェースクラスです。
 *
 * @reamsid_L DBE-1630-020 xuyongchao
 */
public interface IjizenShinsaKekkaMapper {

    /**
     * 事前審査会用のデータを取得する
     *
     * @param parameter 調査委託先・調査員一覧表のMybatisパラメータクラス
     * @return List<JizenShinsaKekkaRelateEntity>
     */
    List<JizenShinsaKekkaRelateEntity> getJizenShinsaKekka(JizenShinsakekkaMybatisParameter parameter);

    /**
     * 介護認定審査会開催予定情報を取得する
     *
     * @param parameter 介護認定審査会開催番号
     * @return DbT5501ShinsakaiKaisaiYoteiJohoEntity
     */
    DbT5501ShinsakaiKaisaiYoteiJohoEntity getShinsakaiKaisaiYoteiJoho(RString parameter);

}
