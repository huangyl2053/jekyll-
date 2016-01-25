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

//        if (get帳票用Entityリスト().isEmpty()) {
//            //TODO 内部：QA273　Redmine：#72186 被保険者証一覧表編集クラスが未実装
//        } else {
//            //TODO 内部：QA273　Redmine：#72186  被保険者証一覧表編集クラスが未実装
//        }
    }

    /**
     * TODO Redmine：#73393　出力順IDから出力順を取得し、被保険者証用Entityリストをソートする
     *
     */
    private List<IkkatsuHakkoRelateEntity> get帳票用Entityリスト() {
        List<IkkatsuHakkoRelateEntity> 被保険者証用Entityリスト = get被保険者証用();
//        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 被保険者証用Entityリスト) {
//            //TODO 内部：QA273　Redmine：#72186 被保険者証編集クラスが未実装
//        }
        return 帳票用Entityリスト;
    }

    private List<IkkatsuHakkoRelateEntity> get被保険者証用() {
        return iIkkatsuHakkoMapper.getHihokenshayo();
    }

    private List<IkkatsuHakkoRelateEntity> get被保険者証一覧() {
        return iIkkatsuHakkoMapper.getHihokenshaIchiran();
    }

}
