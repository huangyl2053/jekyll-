/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150040;

import java.math.BigDecimal;
import jp.co.ndensan.reams.db.dbc.business.report.heikinriyogakutokeihyo.HeikinRiyoGakuTokeihyoReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.heikinriyogakuyokeihyo.HeikinriyogakuTokeihyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.HeikinRiyoGakuTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.ShikakutempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.heikinriyogakutokeihyo.HeikinRiyoGakuTokeihyoReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.hekinriyogakutokehyo.HekinRiyoGakuTokehyo;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 平均利用額統計帳票作成
 *
 * @reamsid_L DBC-3490-030 yaoyahui
 */
public class HeikinRiyoGakuTokeihyoCyouHyouProcess extends BatchProcessBase<ShikakutempTblEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hekinriyogakutokehyo.IHekinRiyoGakuTokehyoMapper."
            + "get平均利用額統計Entity");
    private static final RString 地区指定_0 = new RString("0");
    private static final RString 地区指定_1 = new RString("1");
    private static final RString 地区指定_2 = new RString("2");
    private static final RString 地区指定_3 = new RString("3");
    private static final RString 地区指定_4 = new RString("4");
    private static final RString 地区指定_5 = new RString("5");
    private static final RString 所得段階_6 = new RString("6");
    private static final RString 所得段階_7 = new RString("7");
    private static final RString 所得段階_8 = new RString("8");
    private static final RString 所得段階_9 = new RString("9");
    private static final RString 集計内容_人数 = new RString("人数");
    private static final RString 提供月 = new RString("提供月");
    private static final RString 審査月 = new RString("審査月");
    private static final RString 值000000 = new RString("000000");
    private static final RString 市町村名 = new RString("市町村名");
    private static final RString 旧市町村名 = new RString("旧市町村名");
    private static final RString 住所 = new RString("住所");
    private static final RString 行政区 = new RString("行政区");
    private static final RString 地区1 = new RString("地区1");
    private static final RString 地区2 = new RString("地区2");
    private static final RString 地区3 = new RString("地区3");
    private static final RString 集計内容_費用総額 = new RString("費用総額");
    private static final RString 集計内容_平均額 = new RString("平均額");
    private static final RString 所得段階_以上 = new RString("10以上");
    private static final int 計算用_3 = 3;
    @BatchWriter
    private BatchReportWriter<HeikinRiyoGakuTokeihyoReportSource> batchReportWriter;
    private ReportSourceWriter<HeikinRiyoGakuTokeihyoReportSource> reportSourceWriter;
    private int count = 0;
    private HeikinriyogakuTokeihyoProcessParameter paramter;
    private static final RString 帳票ID = ReportIdDBC.DBC300004.getReportId().value();
    private HeikinRiyoGakuTokeihyoEntity heikinRiyoGakuTokeihyoEntity = new HeikinRiyoGakuTokeihyoEntity();
    private RDateTime now;

    @Override
    protected void initialize() {
        HekinRiyoGakuTokehyo hekinRiyoGakuTokehyo = HekinRiyoGakuTokehyo.createInstance();
        hekinRiyoGakuTokehyo.get給付実績データ取得処理();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        now = RDateTime.now();
    }

    @Override
    protected void process(ShikakutempTblEntity entity) {
        count++;
        editHeikinRiyoGakuTokeihyoEntity(heikinRiyoGakuTokeihyoEntity);
        if (集計内容_人数.equals(entity.getShukeinaiyou())) {
            heikinRiyoGakuTokeihyoEntity.set人数明細_要支援１(getRString(entity.getYoshien1()));
            heikinRiyoGakuTokeihyoEntity.set人数明細_要支援２(getRString(entity.getYoshien2()));
            heikinRiyoGakuTokeihyoEntity.set人数明細_経過的要支援(getRString(entity.getKeikanoyokaigo()));
            heikinRiyoGakuTokeihyoEntity.set人数明細_要介護１(getRString(entity.getYokaigo1()));
            heikinRiyoGakuTokeihyoEntity.set人数明細_要介護２(getRString(entity.getYokaigo2()));
            heikinRiyoGakuTokeihyoEntity.set人数明細_要介護３(getRString(entity.getYokaigo3()));
            heikinRiyoGakuTokeihyoEntity.set人数明細_要介護４(getRString(entity.getYokaigo4()));
            heikinRiyoGakuTokeihyoEntity.set人数明細_要介護５(getRString(entity.getYokaigo5()));
            heikinRiyoGakuTokeihyoEntity.set人数明細_合計(getRString(entity.getGokeichi()));
        }
        if (集計内容_費用総額.equals(entity.getShukeinaiyou())) {
            heikinRiyoGakuTokeihyoEntity.set費用総額明細_要支援１(getRString(entity.getYoshien1()));
            heikinRiyoGakuTokeihyoEntity.set費用総額明細_要支援２(getRString(entity.getYoshien2()));
            heikinRiyoGakuTokeihyoEntity.set費用総額明細_経過的要支援(getRString(entity.getKeikanoyokaigo()));
            heikinRiyoGakuTokeihyoEntity.set費用総額明細_要介護１(getRString(entity.getYokaigo1()));
            heikinRiyoGakuTokeihyoEntity.set費用総額明細_要介護２(getRString(entity.getYokaigo2()));
            heikinRiyoGakuTokeihyoEntity.set費用総額明細_要介護３(getRString(entity.getYokaigo3()));
            heikinRiyoGakuTokeihyoEntity.set費用総額明細_要介護４(getRString(entity.getYokaigo4()));
            heikinRiyoGakuTokeihyoEntity.set費用総額明細_要介護５(getRString(entity.getYokaigo5()));
            heikinRiyoGakuTokeihyoEntity.set費用総額明細_合計(getRString(entity.getGokeichi()));
            if (new RString("30").equals(entity.getPageNO())) {
                heikinRiyoGakuTokeihyoEntity.set費用総額明細_要介護５(getRString(entity.getYokaigo5()));
            }
        }
        heikinRiyoGakuTokeihyoEntity.setページ数(entity.getPageNO());
        heikinRiyoGakuTokeihyoEntity.setサービス種類名称(entity.getServiceshurui());
        if (所得段階_6.equals(entity.getShotoku()) && RString.isNullOrEmpty(entity.getHokenseiteitoku())) {
            heikinRiyoGakuTokeihyoEntity.set所得段階６(RString.EMPTY);
        } else {
            heikinRiyoGakuTokeihyoEntity.set所得段階６(所得段階_6);
            heikinRiyoGakuTokeihyoEntity.set人数６(集計内容_人数);
            heikinRiyoGakuTokeihyoEntity.set費用総額６(集計内容_費用総額);
            heikinRiyoGakuTokeihyoEntity.set平均額６(集計内容_平均額);
        }
        if (所得段階_7.equals(entity.getShotoku()) && RString.isNullOrEmpty(entity.getHokenseiteitoku())) {
            heikinRiyoGakuTokeihyoEntity.set所得段階７(RString.EMPTY);

        } else {
            heikinRiyoGakuTokeihyoEntity.set所得段階７(所得段階_7);
            heikinRiyoGakuTokeihyoEntity.set人数７(集計内容_人数);
            heikinRiyoGakuTokeihyoEntity.set費用総額７(集計内容_費用総額);
            heikinRiyoGakuTokeihyoEntity.set平均額７(集計内容_平均額);
        }
        if (所得段階_8.equals(entity.getShotoku()) && RString.isNullOrEmpty(entity.getHokenseiteitoku())) {
            heikinRiyoGakuTokeihyoEntity.set所得段階８(RString.EMPTY);
        } else {
            heikinRiyoGakuTokeihyoEntity.set所得段階８(所得段階_8);
            heikinRiyoGakuTokeihyoEntity.set人数８(集計内容_人数);
            heikinRiyoGakuTokeihyoEntity.set費用総額８(集計内容_費用総額);
            heikinRiyoGakuTokeihyoEntity.set平均額８(集計内容_平均額);
        }
        if (所得段階_9.equals(entity.getShotoku()) && RString.isNullOrEmpty(entity.getHokenseiteitoku())) {
            heikinRiyoGakuTokeihyoEntity.set所得段階９(RString.EMPTY);
        } else {
            heikinRiyoGakuTokeihyoEntity.set所得段階９(所得段階_9);
            heikinRiyoGakuTokeihyoEntity.set人数９(集計内容_人数);
            heikinRiyoGakuTokeihyoEntity.set費用総額９(集計内容_費用総額);
            heikinRiyoGakuTokeihyoEntity.set平均額９(集計内容_平均額);
        }
        if (所得段階_以上.equals(entity.getShotoku()) && RString.isNullOrEmpty(entity.getHokenseiteitoku())) {
            heikinRiyoGakuTokeihyoEntity.set所得段階１０(RString.EMPTY);
        } else {
            heikinRiyoGakuTokeihyoEntity.set所得段階１０(所得段階_以上);
            heikinRiyoGakuTokeihyoEntity.set人数１０(集計内容_人数);
            heikinRiyoGakuTokeihyoEntity.set費用総額１０(集計内容_費用総額);
            heikinRiyoGakuTokeihyoEntity.set平均額１０(集計内容_平均額);
        }

        if (count == 計算用_3) {
            heikinRiyoGakuTokeihyoEntity.set平均額明細_要支援１(toDecimal(heikinRiyoGakuTokeihyoEntity.get費用総額明細_要支援１(),
                    heikinRiyoGakuTokeihyoEntity.get人数明細_要支援１()));
            heikinRiyoGakuTokeihyoEntity.set平均額明細_要支援２(toDecimal(heikinRiyoGakuTokeihyoEntity.get費用総額明細_要支援２(),
                    heikinRiyoGakuTokeihyoEntity.get人数明細_要支援２()));
            heikinRiyoGakuTokeihyoEntity.set平均額明細_経過的要支援(toDecimal(heikinRiyoGakuTokeihyoEntity.get費用総額明細_経過的要支援(),
                    heikinRiyoGakuTokeihyoEntity.get人数明細_経過的要支援()));
            heikinRiyoGakuTokeihyoEntity.set平均額明細_要介護１(toDecimal(heikinRiyoGakuTokeihyoEntity.get費用総額明細_要介護１(),
                    heikinRiyoGakuTokeihyoEntity.get人数明細_要介護１()));
            heikinRiyoGakuTokeihyoEntity.set平均額明細_要介護２(toDecimal(heikinRiyoGakuTokeihyoEntity.get費用総額明細_要介護２(),
                    heikinRiyoGakuTokeihyoEntity.get人数明細_要介護２()));
            heikinRiyoGakuTokeihyoEntity.set平均額明細_要介護３(toDecimal(heikinRiyoGakuTokeihyoEntity.get費用総額明細_要介護３(),
                    heikinRiyoGakuTokeihyoEntity.get人数明細_要介護３()));
            heikinRiyoGakuTokeihyoEntity.set平均額明細_要介護４(toDecimal(heikinRiyoGakuTokeihyoEntity.get費用総額明細_要介護４(),
                    heikinRiyoGakuTokeihyoEntity.get人数明細_要介護４()));
            heikinRiyoGakuTokeihyoEntity.set平均額明細_要介護５(toDecimal(heikinRiyoGakuTokeihyoEntity.get費用総額明細_要介護５(),
                    heikinRiyoGakuTokeihyoEntity.get人数明細_要介護５()));
            heikinRiyoGakuTokeihyoEntity.set平均額明細_合計(toDecimal(heikinRiyoGakuTokeihyoEntity.get費用総額明細_合計(),
                    heikinRiyoGakuTokeihyoEntity.get人数明細_合計()));
            HeikinRiyoGakuTokeihyoReport report = new HeikinRiyoGakuTokeihyoReport(heikinRiyoGakuTokeihyoEntity, now);
            report.writeBy(reportSourceWriter);
            heikinRiyoGakuTokeihyoEntity = new HeikinRiyoGakuTokeihyoEntity();
            count = 0;
        }
    }

    private void editHeikinRiyoGakuTokeihyoEntity(HeikinRiyoGakuTokeihyoEntity heikinRiyoGakuTokeihyoEntity) {
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 保険者名称 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (地区指定_1.equals(paramter.getTaishoNendoYM())) {
            if (!paramter.getKaishiYM().equals(paramter.getShuryoYM())) {
                RStringBuilder rb = new RStringBuilder();
                rb.append(提供月);
                rb.append(":");
                rb.append((setDateFormat(paramter.getKaishiYM())));
                rb.append("-");
                rb.append((setDateFormat(paramter.getShuryoYM())));
                RString 条件１ = rb.toRString();
                heikinRiyoGakuTokeihyoEntity.set条件1(条件１);
            } else {
                RStringBuilder rb = new RStringBuilder();
                rb.append(提供月);
                rb.append(":");
                rb.append((setDateFormat(paramter.getKaishiYM())));
                RString 条件１ = rb.toRString();
                heikinRiyoGakuTokeihyoEntity.set条件1(条件１);
            }
        } else if (地区指定_2.equals(paramter.getTaishoNendoYM())) {
            if (!paramter.getKaishiYM().equals(paramter.getShuryoYM())) {
                RStringBuilder rb = new RStringBuilder();
                rb.append(審査月);
                rb.append(":");
                rb.append((setDateFormat(paramter.getKaishiYM())));
                rb.append("-");
                rb.append((setDateFormat(paramter.getShuryoYM())));
                RString 条件１ = rb.toRString();
                heikinRiyoGakuTokeihyoEntity.set条件1(条件１);
            } else {
                RStringBuilder rb = new RStringBuilder();
                rb.append(審査月);
                rb.append(":");
                rb.append((setDateFormat(paramter.getKaishiYM())));
                RString 条件１ = rb.toRString();
                heikinRiyoGakuTokeihyoEntity.set条件1(条件１);
            }
        }
        if ((!RString.isNullOrEmpty(paramter.getShichosonCode()) && !值000000.equals(paramter.getShichosonCode()))
                && (RString.isNullOrEmpty(paramter.getKyuShichosonCode()) || 值000000.equals(paramter.getKyuShichosonCode()))) {
            RStringBuilder rb = new RStringBuilder();
            rb.append(市町村名);
            rb.append(":");
            rb.append(paramter.getShichosonMei());
            RString 条件2 = rb.toRString();
            heikinRiyoGakuTokeihyoEntity.set条件2(条件2);
        } else if ((!RString.isNullOrEmpty(paramter.getKyuShichosonCode())) && !值000000.equals(paramter.getKyuShichosonCode())) {
            RStringBuilder rb = new RStringBuilder();
            rb.append(旧市町村名);
            rb.append(":");
            rb.append(paramter.getKyuShichosonMei());
            RString 条件2 = rb.toRString();
            heikinRiyoGakuTokeihyoEntity.set条件2(条件2);
        } else if (paramter.getShichosonCode().isEmpty() && paramter.getKyuShichosonCode().isEmpty()) {
            if (地区指定_1.equals(paramter.getChikuShitei())) {
                RStringBuilder rb = new RStringBuilder();
                rb.append(住所);
                rb.append(":");
                rb.append(paramter.get選択地区().get(0));
                rb.append("～");
                rb.append(paramter.get選択地区().get(paramter.get選択地区().size() - 1));
                RString 条件2 = rb.toRString();
                heikinRiyoGakuTokeihyoEntity.set条件2(条件2);
            } else if (地区指定_2.equals(paramter.getChikuShitei())) {
                RStringBuilder rb = new RStringBuilder();
                rb.append(行政区);
                rb.append(":");
                rb.append(paramter.get選択地区().get(0));
                rb.append("～");
                rb.append(paramter.get選択地区().get(paramter.get選択地区().size() - 1));
                RString 条件2 = rb.toRString();
                heikinRiyoGakuTokeihyoEntity.set条件2(条件2);
            } else if (地区指定_3.equals(paramter.getChikuShitei())) {
                RStringBuilder rb = new RStringBuilder();
                rb.append(地区1);
                rb.append(":");
                rb.append(paramter.get選択地区().get(0));
                rb.append("～");
                rb.append(paramter.get選択地区().get(paramter.get選択地区().size() - 1));
                RString 条件2 = rb.toRString();
                heikinRiyoGakuTokeihyoEntity.set条件2(条件2);
            } else if (地区指定_4.equals(paramter.getChikuShitei())) {
                RStringBuilder rb = new RStringBuilder();
                rb.append(地区2);
                rb.append(":");
                rb.append(paramter.get選択地区().get(0));
                rb.append("～");
                rb.append(paramter.get選択地区().get(paramter.get選択地区().size() - 1));
                RString 条件2 = rb.toRString();
                heikinRiyoGakuTokeihyoEntity.set条件2(条件2);
            } else if (地区指定_5.equals(paramter.getChikuShitei())) {
                RStringBuilder rb = new RStringBuilder();
                rb.append(地区3);
                rb.append(":");
                rb.append(paramter.get選択地区().get(0));
                rb.append("～");
                rb.append(paramter.get選択地区().get(paramter.get選択地区().size() - 1));
                RString 条件2 = rb.toRString();
                heikinRiyoGakuTokeihyoEntity.set条件2(条件2);
            } else {
                heikinRiyoGakuTokeihyoEntity.set条件2(RString.EMPTY);
            }
        }
        heikinRiyoGakuTokeihyoEntity.set保険者番号(保険者番号);
        heikinRiyoGakuTokeihyoEntity.set保険者名(保険者名称);

    }

    private RString toDecimal(RString obj1, RString obj2) {

        if (RString.isNullOrEmpty(obj1) || RString.isNullOrEmpty(obj2)
                || 0 == Integer.valueOf(obj1.toString()) || 0 == Integer.valueOf(obj2.toString())) {
            return 地区指定_0;
        } else {
            return new RString(new BigDecimal((new Decimal(obj1.toString()).divide(new Decimal(obj2.toString()))).toString())
                    .setScale(0, BigDecimal.ROUND_HALF_UP).toString());
        }
    }

    private RString setDateFormat(RString date) {
        RString formatDate = RString.EMPTY;
        if (!RString.isNullOrEmpty(date)) {
            formatDate = new FlexibleDate(date).wareki().toDateString();
        }
        return formatDate;
    }

    private RString getRString(Decimal decimal) {
        return new RString(String.valueOf(decimal));
    }
}
