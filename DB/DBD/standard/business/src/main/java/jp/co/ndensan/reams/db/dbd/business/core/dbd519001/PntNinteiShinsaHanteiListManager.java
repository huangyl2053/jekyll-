/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd519001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.PntNinteiShinsaHanteiListProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho.ChohyoShuchiryokuyoShiseiJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.PntNinteiShinsaHanteiListEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd503001.ShinsaHanteiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定審査判定依頼一覧表発行_business処理クラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
public class PntNinteiShinsaHanteiListManager {

    private static final RString 認定申請IF種類 = new RString("【認定申請IF種類】");
    private static final RString 証記載保険者番号 = new RString("【証記載保険者番号】");
    private static final RString 市町村コード = new RString("【市町村コード】");
    private static final RString 被保険者番号 = new RString("【被保険者番号】");
    private static final RString 抽出開始日時 = new RString("【抽出開始日時】");
    private static final RString 抽出終了日時 = new RString("【抽出終了日時】: ");

    /**
     * 認定審査判定依頼一覧表発行。
     *
     * @param entity PntNinteiShinsaHanteiListEntity
     * @param i int
     * @param 市町村名 RString
     * @param parameter PntNinteiShinsaHanteiListProcessParameter
     * @return ChohyoShuchiryokuyoShiseiJyohoEntity
     */
    public ChohyoShuchiryokuyoShiseiJyohoEntity createEntity(PntNinteiShinsaHanteiListEntity entity,
            int i,
            RString 市町村名,
            PntNinteiShinsaHanteiListProcessParameter parameter) {
        ChohyoShuchiryokuyoShiseiJyohoEntity 帳票出力用申請情報Entityリスト = new ChohyoShuchiryokuyoShiseiJyohoEntity();
        帳票出力用申請情報Entityリスト.setIndex(i);
        帳票出力用申請情報Entityリスト.set住所(entity.get住所());
        帳票出力用申請情報Entityリスト.set保険者名称(市町村名);
        帳票出力用申請情報Entityリスト.set出力CSV状況申請(RString.EMPTY);
        帳票出力用申請情報Entityリスト.set前回要介護状態区分コード(entity.get前回要介護状態区分コード());
        帳票出力用申請情報Entityリスト.set前回認定有効期間終了(entity.get前回認定有効期間_終了());
        帳票出力用申請情報Entityリスト.set前回認定有効期間開始(entity.get前回認定有効期間_開始());
        帳票出力用申請情報Entityリスト.set性別(entity.get性別().value());
        帳票出力用申請情報Entityリスト.set生年月日(entity.get生年月日());
        帳票出力用申請情報Entityリスト.set申請届出代行区分コード(Code.EMPTY);
        帳票出力用申請情報Entityリスト.set被保険者区分コード(entity.get被保険者区分コード());
        帳票出力用申請情報Entityリスト.set被保険者氏名(entity.get被保険者氏名());
        帳票出力用申請情報Entityリスト.set被保険者氏名カナ(entity.get被保険者氏名カナ());
        帳票出力用申請情報Entityリスト.set被保険者番号(new HihokenshaNo(entity.get被保険者番号()));
        帳票出力用申請情報Entityリスト.set証記載保険者番号(new ShoKisaiHokenshaNo(parameter.get証記載保険者番号()));
        帳票出力用申請情報Entityリスト.set認定申請区分_申請時コード(entity.get認定申請区分_申請時_コード());
        帳票出力用申請情報Entityリスト.set認定申請年月日(entity.get認定申請年月日());
        帳票出力用申請情報Entityリスト.set識別コード(ShikibetsuCode.EMPTY);
        return 帳票出力用申請情報Entityリスト;
    }

    /**
     * バッチ出力条件リストの出力。
     *
     * @param 地方公共団体 Association
     * @param batchReportWriter BatchReportWriter<ShinsaHanteiIraiIchiranhyoReportSource>
     * @param parameter PntNinteiShinsaHanteiListProcessParameter
     * @return ReportOutputJokenhyoItem
     */
    public ReportOutputJokenhyoItem バッチ出力条件リストの出力(Association 地方公共団体,
            BatchReportWriter<ShinsaHanteiIraiIchiranhyoReportSource> batchReportWriter, PntNinteiShinsaHanteiListProcessParameter parameter) {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().getColumnValue();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 出力ページ数 = new RString(String.valueOf(batchReportWriter.getPageCount()));
        RString 出力有無 = new RString("なし");
        RString ファイル名 = RString.EMPTY;
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(認定申請IF種類.concat(parameter.get認定申請IF種類()));
        if (parameter.get証記載保険者番号() != null) {
            出力条件.add(証記載保険者番号.concat(parameter.get証記載保険者番号()));
        } else {
            出力条件.add(証記載保険者番号.concat(RString.HALF_SPACE));
        }
        if (parameter.get市町村コード() != null) {
            出力条件.add(市町村コード.concat(parameter.get市町村コード().value()));
        } else {
            出力条件.add(市町村コード.concat(RString.HALF_SPACE));
        }
        出力条件.add(被保険者番号.concat(parameter.get被保険者番号().value()));
        出力条件.add(抽出開始日時.concat(parameter.get抽出開始日時().toString()));
        出力条件.add(抽出終了日時.concat(parameter.get抽出終了日時().toString()));
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                市町村名,
                導入団体コード,
                市町村名,
                ジョブ番号,
                市町村名,
                出力ページ数,
                出力有無,
                ファイル名,
                出力条件);
        return reportOutputJokenhyoItem;
    }
}
