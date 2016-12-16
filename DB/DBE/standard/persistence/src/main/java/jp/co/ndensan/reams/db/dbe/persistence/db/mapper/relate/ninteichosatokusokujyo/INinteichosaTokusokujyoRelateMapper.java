/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosatokusokujyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosatokusokujyo.NinteiChosaTokusokujoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo.AtenaKikan;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo.NinteiChosaTokusokujoRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査督促状発行のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
public interface INinteichosaTokusokujyoRelateMapper {

    /**
     * 要介護認定調査督促状パラメータを取得します。
     *
     * @param parameter 検索条件
     * @return 要介護認定申請情報テーブルのエンティティのリスト
     * 検索結果の{@link NinteiChosaTokusokujoRelateEntity}
     */
    List<NinteiChosaTokusokujoRelateEntity> select要介護認定調査督促状ByKey(NinteiChosaTokusokujoMybatisParameter parameter);

    /**
     * 認定調査督促対象者一覧表パラメータを取得します。
     *
     * @param parameter 検索条件
     * @return NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity
     * 検索結果の{@link NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity}
     */
    List<NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity>
            select認定調査督促対象者一覧表ByKey(NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter parameter);

    /**
     * 市町村コードを取得します。
     *
     * @param 保険者コード 保険者コード
     * @return DbT7051KoseiShichosonMasterEntity
     * 検索結果の{@link DbT7051KoseiShichosonMasterEntity}
     */
    DbT7051KoseiShichosonMasterEntity select市町村コード(RString 保険者コード);

    /**
     * 宛名機関名等を取得します。
     *
     * @param parameter 検索条件
     * @return 宛名機関 検索結果の{@link AtenaKikan}
     */
    AtenaKikan select宛名機関(NinteiChosaTokusokujoMybatisParameter parameter);

}
