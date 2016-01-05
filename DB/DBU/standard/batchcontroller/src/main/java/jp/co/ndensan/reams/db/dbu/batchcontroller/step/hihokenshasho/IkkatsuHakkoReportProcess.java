/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.IkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho.IIkkatsuHakkoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 被保険者証一括発行_バッチフ処理クラスです
 */
public class IkkatsuHakkoReportProcess extends SimpleBatchProcessBase {

    private IIkkatsuHakkoMapper iIkkatsuHakkoMapper;
    private List<IkkatsuHakkoRelateEntity> 帳票用Entityリスト;

    @Override
    protected void beforeExecute() {
        iIkkatsuHakkoMapper = getMapper(IIkkatsuHakkoMapper.class);

    }

    @Override
    protected void afterExecute() {
    }

    @Override
    protected void process() {

    }

    /**
     * 帳票用Entityリストを取得します。
     *
     * @return 帳票用Entityリスト
     */
    private List<IkkatsuHakkoRelateEntity> get帳票用Entityリスト() {
        List<IkkatsuHakkoRelateEntity> 被保険者証用Entityリスト = get被保険者証用();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 被保険者証用Entityリスト) {

        }
        return 帳票用Entityリスト;
    }

    /**
     * 被保険者証用データを取得します。
     *
     * @return 被保険者証用Entityリスト
     */
    private List<IkkatsuHakkoRelateEntity> get被保険者証用() {
        return iIkkatsuHakkoMapper.getHihokenshayo();
    }

    /**
     * 被保険者証一覧表用を取得します。
     *
     * @return 被保険者証一覧表用Entityリスト
     */
    private List<IkkatsuHakkoRelateEntity> get被保険者証一覧() {
        return iIkkatsuHakkoMapper.getHihokenshaIchiran();
    }

}
