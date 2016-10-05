/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.dankaibetsuhihokenshasuichiranhyosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt21004.DankaibetuHihokensyasuIchiranhyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibehihokensixya.DankaibeHihokensixyaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaiprocessentity.DankaiProcessEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.setaiinhaakuinputtable.TmpSetaiHaaku;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 段階別被保険者数一覧表作成のインタフェースです。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
public interface IDankaibetsuHihokenshasuIchiranhyoSakuseiMapper {

    /**
     * 資格情報 被保険者台帳管理の全項目
     *
     * @param parameter DankaibetuHihokensyasuIchiranhyoProcessParameter
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    List<DbT1001HihokenshaDaichoEntity> select資格の情報(DankaibetuHihokensyasuIchiranhyoMyBatisParameter parameter);

    /**
     * 世帯員把握入力テーブル
     *
     * @return List<TmpSetaiHaaku>
     */
    List<TmpSetaiHaaku> select世帯員把握();

    /**
     * 段階情報取得
     *
     * @param parameter DankaibetuHihokensyasuIchiranhyoMyBatisParameter
     * @return List<DankaiProcessEntity>
     */
    List<DankaiProcessEntity> select段階情報取得(DankaibetuHihokensyasuIchiranhyoMyBatisParameter parameter);

    /**
     * 段階別被保険者数のCSV出力
     *
     * @param parameter DankaibetuHihokensyasuIchiranhyoProcessParameter
     * @return List<DankaibeHihokensixyaEntity>
     */
    List<DankaibeHihokensixyaEntity> selectCSV出力対象データ(DankaibetuHihokensyasuIchiranhyoMyBatisParameter parameter);

    /**
     * 段階別被保険者数の帳票出力
     *
     * @param parameter DankaibetuHihokensyasuIchiranhyoProcessParameter
     * @return List<DankaibeHihokensixyaEntity>
     */
    List<DankaibeHihokensixyaEntity> select帳票出力対象データ(DankaibetuHihokensyasuIchiranhyoMyBatisParameter parameter);

}
