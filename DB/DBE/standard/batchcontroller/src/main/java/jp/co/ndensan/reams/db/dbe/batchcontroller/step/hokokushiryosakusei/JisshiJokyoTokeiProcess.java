package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jisshijokyotokei.JisshiJokyoTokei;
import jp.co.ndensan.reams.db.dbe.business.report.jisshijokyotokei.JisshiJokyoTokeiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.JisshiJokyoTokeiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.JisshiJokyoTokeiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.JisshiJokyoTokeiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jisshijokyotokei.JisshiJokyoTokeiReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定実施状況統計情報の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class JisshiJokyoTokeiProcess extends SimpleBatchProcessBase {

    private static final RString 申請受付 = new RString("0");
    private static final RString 調査実施 = new RString("1");
    private static final RString 審査会実施 = new RString("2");
    private static final RString 認定結果 = new RString("3");
    private static final RString タイトル = new RString("要介護認定実施状況統計");
    private static final RString 開始年月日 = new RString("最初から");
    private static final RString 終了年月日 = new RString("最終まで");
    private static final RString 申請受付数タイトル = new RString("申請受付人数");
    private static final RString 調査実施数タイトル = new RString("調査実施人数");
    private static final RString 審査会実施数タイトル = new RString("審査会開実施人数");
    private static final RString 認定結果数タイトル = new RString("認定結果人数");
    private static final RString 新規申請タイトル = new RString("新規");
    private static final RString 更新申請タイトル = new RString("更新");
    private static final RString 区分変更申請タイトル = new RString("区分変更");
    private static final RString 合計タイトル = new RString("合計");
    private JisshiJokyoTokeiProcessParameter parameter;
    private JisshiJokyoTokeiMyBatisParameter batisParameter;
    private JisshiJokyoTokei jisshiJokyoTokei;
    private IHokokuShiryoSakuSeiMapper mapper;
    @BatchWriter
    private BatchReportWriter<JisshiJokyoTokeiReportSource> batchWriter;
    private ReportSourceWriter<JisshiJokyoTokeiReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IHokokuShiryoSakuSeiMapper.class);
        batisParameter = parameter.toJisshiJokyoTokeiMyBatisParameter();
        jisshiJokyoTokei = new JisshiJokyoTokei();
    }

    @Override
    protected void process() {
        jisshiJokyoTokei.setタイトル(タイトル);
        set開始終了年月日();
        jisshiJokyoTokei.set発行日時(RDateTime.now());
        jisshiJokyoTokei.set申請受付数タイトル(申請受付数タイトル);
        jisshiJokyoTokei.set調査実施数タイトル(調査実施数タイトル);
        jisshiJokyoTokei.set審査会実施数タイトル(審査会実施数タイトル);
        jisshiJokyoTokei.set認定結果数タイトル(認定結果数タイトル);
        jisshiJokyoTokei.set新規申請タイトル(新規申請タイトル);
        jisshiJokyoTokei.set更新申請タイトル(更新申請タイトル);
        jisshiJokyoTokei.set区分変更申請タイトル(区分変更申請タイトル);
        jisshiJokyoTokei.set合計タイトル(合計タイトル);
        set申請受付();
        set調査実施();
        set審査会実施();
        set認定結果();
        set合計();
    }

    @Override
    protected void afterExecute() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE701003.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
        JisshiJokyoTokeiReport report = new JisshiJokyoTokeiReport(jisshiJokyoTokei);
        report.writeBy(reportSourceWriter);
        batchWriter.close();
    }

    private void set開始終了年月日() {
        if (parameter.isTaishoTsukiKubun()) {
            RYearMonth 対象年月 = new RYearMonth(parameter.getTaishoNendoYM());
            jisshiJokyoTokei.set抽出開始年月日(new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 1).toDateString());
            jisshiJokyoTokei.set抽出終了年月日(new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 対象年月.getLastDay()).toDateString());
        } else {
            if (!parameter.isEmptyTaishoGeppiFrom() && !parameter.isEmptyTaishoGeppiTo()) {
                jisshiJokyoTokei.set抽出開始年月日(parameter.getTaishoGeppiFrom());
                jisshiJokyoTokei.set抽出終了年月日(parameter.getTaishoGeppiTo());
            } else if (parameter.isEmptyTaishoGeppiFrom()) {
                jisshiJokyoTokei.set抽出開始年月日(開始年月日);
                jisshiJokyoTokei.set抽出終了年月日(parameter.getTaishoGeppiTo());
            } else {
                jisshiJokyoTokei.set抽出開始年月日(parameter.getTaishoGeppiFrom());
                jisshiJokyoTokei.set抽出終了年月日(終了年月日);
            }
        }
    }

    private void set申請受付() {
        batisParameter.setNiTeiJokyo(申請受付);
        List<JisshiJokyoTokeiEntity> 申請受付List = mapper.getJisshiJokyoTokei(batisParameter);
        set保険者(申請受付List);
        int 新規申請受付数申請時 = 0;
        int 更新申請受付数申請時 = 0;
        int 区分変更申請受付数申請時 = 0;
        if (parameter.isShinseiji()) {
            for (JisshiJokyoTokeiEntity entity : 申請受付List) {
                if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    新規申請受付数申請時 = entity.getCountKensu();
                }
                if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    更新申請受付数申請時 = entity.getCountKensu();
                }
                if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    区分変更申請受付数申請時 = entity.getCountKensu();
                }
            }
        }
        int 新規申請受付数法令 = 0;
        int 更新申請受付数法令 = 0;
        int 区分変更申請受付数法令 = 0;
        if (parameter.isHorei()) {
            for (JisshiJokyoTokeiEntity entity : 申請受付List) {
                if (NinteiShinseiHoreiCode.新規申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    新規申請受付数法令 = entity.getCountKensu();
                }
                if (NinteiShinseiHoreiCode.更新申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    更新申請受付数法令 = entity.getCountKensu();
                }
                if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    区分変更申請受付数法令 = entity.getCountKensu();
                }
            }
        }
        jisshiJokyoTokei.set新規申請_申請受付数(new RString(新規申請受付数申請時 + 新規申請受付数法令));
        jisshiJokyoTokei.set更新申請_申請受付数(new RString(更新申請受付数申請時 + 更新申請受付数法令));
        jisshiJokyoTokei.set区分変更申請_申請受付数(new RString(区分変更申請受付数申請時 + 区分変更申請受付数法令));
    }

    private void set調査実施() {
        batisParameter.setNiTeiJokyo(調査実施);
        List<JisshiJokyoTokeiEntity> 調査実施List = mapper.getJisshiJokyoTokei(batisParameter);
        set保険者(調査実施List);
        int 新規調査実施数申請時 = 0;
        int 更新調査実施数申請時 = 0;
        int 区分変更調査実施数申請時 = 0;
        if (parameter.isShinseiji()) {
            for (JisshiJokyoTokeiEntity entity : 調査実施List) {
                if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    新規調査実施数申請時 = 新規調査実施数申請時 + entity.getCountKensu();
                }
                if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    更新調査実施数申請時 = 新規調査実施数申請時 + entity.getCountKensu();
                }
                if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    区分変更調査実施数申請時 = 区分変更調査実施数申請時 + entity.getCountKensu();
                }
            }
        }
        int 新規調査実施数法令 = 0;
        int 更新調査実施数法令 = 0;
        int 区分変更調査実施数法令 = 0;
        if (parameter.isHorei()) {
            for (JisshiJokyoTokeiEntity entity : 調査実施List) {
                if (NinteiShinseiHoreiCode.新規申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    新規調査実施数法令 = 新規調査実施数法令 + entity.getCountKensu();
                }
                if (NinteiShinseiHoreiCode.更新申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    更新調査実施数法令 = 更新調査実施数法令 + entity.getCountKensu();
                }
                if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    区分変更調査実施数法令 = 区分変更調査実施数法令 + entity.getCountKensu();
                }
            }
        }
        jisshiJokyoTokei.set新規申請_調査実施数(new RString(新規調査実施数申請時 + 新規調査実施数法令));
        jisshiJokyoTokei.set更新申請_調査実施数(new RString(更新調査実施数申請時 + 更新調査実施数法令));
        jisshiJokyoTokei.set区分変更申請_調査実施数(new RString(区分変更調査実施数申請時 + 区分変更調査実施数法令));
    }

    private void set審査会実施() {
        batisParameter.setNiTeiJokyo(審査会実施);
        List<JisshiJokyoTokeiEntity> 審査会実施List = mapper.getJisshiJokyoTokei(batisParameter);
        set保険者(審査会実施List);
        int 新規審査会実施数申請時 = 0;
        int 更新審査会実施数申請時 = 0;
        int 区分変更審査会実施数申請時 = 0;
        if (parameter.isShinseiji()) {
            for (JisshiJokyoTokeiEntity entity : 審査会実施List) {
                if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    新規審査会実施数申請時 = 新規審査会実施数申請時 + entity.getCountKensu();
                }
                if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    更新審査会実施数申請時 = 更新審査会実施数申請時 + entity.getCountKensu();
                }
                if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    区分変更審査会実施数申請時 = 区分変更審査会実施数申請時 + entity.getCountKensu();
                }
            }
        }
        int 新規審査会実施数法令 = 0;
        int 更新審査会実施数法令 = 0;
        int 区分変更審査会実施数法令 = 0;
        if (parameter.isHorei()) {
            for (JisshiJokyoTokeiEntity entity : 審査会実施List) {
                if (NinteiShinseiHoreiCode.新規申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    新規審査会実施数法令 = 新規審査会実施数法令 + entity.getCountKensu();
                }
                if (NinteiShinseiHoreiCode.更新申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    更新審査会実施数法令 = 更新審査会実施数法令 + entity.getCountKensu();
                }
                if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    区分変更審査会実施数法令 = 区分変更審査会実施数法令 + entity.getCountKensu();
                }
            }
        }
        jisshiJokyoTokei.set新規申請_審査会実施数(new RString(新規審査会実施数申請時 + 新規審査会実施数法令));
        jisshiJokyoTokei.set更新申請_審査会実施数(new RString(更新審査会実施数申請時 + 更新審査会実施数法令));
        jisshiJokyoTokei.set区分変更申請_審査会実施数(new RString(区分変更審査会実施数申請時 + 区分変更審査会実施数法令));
    }

    private void set認定結果() {
        batisParameter.setNiTeiJokyo(認定結果);
        List<JisshiJokyoTokeiEntity> 認定結果List = mapper.getJisshiJokyoTokei(batisParameter);
        set保険者(認定結果List);
        int 新規認定結果数申請時 = 0;
        int 更新認定結果数申請時 = 0;
        int 区分変更認定結果数申請時 = 0;
        if (parameter.isShinseiji()) {
            for (JisshiJokyoTokeiEntity entity : 認定結果List) {
                if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    新規認定結果数申請時 = 新規認定結果数申請時 + entity.getCountKensu();
                }
                if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    更新認定結果数申請時 = 更新認定結果数申請時 + entity.getCountKensu();
                }
                if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(entity.getNinteiShinseiShinseijiKubunCode().value())) {
                    区分変更認定結果数申請時 = 区分変更認定結果数申請時 + entity.getCountKensu();
                }
            }
        }
        int 新規認定結果数法令 = 0;
        int 更新認定結果数法令 = 0;
        int 区分変更認定結果数法令 = 0;
        if (parameter.isHorei()) {
            for (JisshiJokyoTokeiEntity entity : 認定結果List) {
                if (NinteiShinseiHoreiCode.新規申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    新規認定結果数法令 = 新規認定結果数法令 + entity.getCountKensu();
                }
                if (NinteiShinseiHoreiCode.更新申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    更新認定結果数法令 = 更新認定結果数法令 + entity.getCountKensu();
                }
                if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(entity.getNinteiShinseiHoreiKubunCode().value())) {
                    区分変更認定結果数法令 = 区分変更認定結果数法令 + entity.getCountKensu();
                }
            }
        }
        jisshiJokyoTokei.set新規申請_認定結果数(new RString(新規認定結果数申請時 + 新規認定結果数法令));
        jisshiJokyoTokei.set更新申請_認定結果数(new RString(更新認定結果数申請時 + 更新認定結果数法令));
        jisshiJokyoTokei.set区分変更申請_認定結果数(new RString(区分変更認定結果数申請時 + 区分変更認定結果数法令));
    }

    private void set合計() {
        jisshiJokyoTokei.set合計_申請受付数(new RString(Integer.parseInt(jisshiJokyoTokei.get新規申請_申請受付数().toString())
                + Integer.parseInt(jisshiJokyoTokei.get更新申請_申請受付数().toString())
                + Integer.parseInt(jisshiJokyoTokei.get区分変更申請_申請受付数().toString())));
        jisshiJokyoTokei.set合計_調査実施数(new RString(Integer.parseInt(jisshiJokyoTokei.get新規申請_調査実施数().toString())
                + Integer.parseInt(jisshiJokyoTokei.get更新申請_調査実施数().toString())
                + Integer.parseInt(jisshiJokyoTokei.get区分変更申請_調査実施数().toString())));
        jisshiJokyoTokei.set合計_審査会実施数(new RString(Integer.parseInt(jisshiJokyoTokei.get新規申請_審査会実施数().toString())
                + Integer.parseInt(jisshiJokyoTokei.get更新申請_審査会実施数().toString())
                + Integer.parseInt(jisshiJokyoTokei.get区分変更申請_審査会実施数().toString())));
        jisshiJokyoTokei.set合計_認定結果数(new RString(Integer.parseInt(jisshiJokyoTokei.get新規申請_認定結果数().toString())
                + Integer.parseInt(jisshiJokyoTokei.get更新申請_認定結果数().toString())
                + Integer.parseInt(jisshiJokyoTokei.get区分変更申請_認定結果数().toString())));
    }

    private void set保険者(List<JisshiJokyoTokeiEntity> list) {
        if (list != null && !list.isEmpty()) {
            jisshiJokyoTokei.set保険者番号(list.get(0).getShoKisaiHokenshaNo());
            jisshiJokyoTokei.set保険者名(list.get(0).getShichosonMeisho());
        }
    }
}
