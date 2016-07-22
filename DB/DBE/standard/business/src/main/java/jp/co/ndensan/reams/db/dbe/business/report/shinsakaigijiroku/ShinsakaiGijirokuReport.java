/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaigijiroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.GoGyoumeIchiIchiRanEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.IinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.SanGyoumeKuIchiRanEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.SanGyoumeYonJyoIchiRanEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiGijirokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaigijiroku.ShinsakaiGijirokuReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会議事録のReportです。
 *
 * @reamsid_L DBE-0170-040 wangkun
 */
public class ShinsakaiGijirokuReport extends Report<ShinsakaiGijirokuReportSource> {

    private final ShinsakaiGijirokuEntity item;
    private static final int INDEX_9 = 9;
    private static final int INDEX_8 = 8;
    private static final int INDEX_7 = 7;
    private static final int INDEX_6 = 6;
    private static final int INDEX_5 = 5;
    private static final int INDEX_4 = 4;
    private static final int INDEX_3 = 3;
    private static final int INDEX_2 = 2;
    private static final int INDEX_1 = 1;
    private static final int INDEX_0 = 0;

    private final List<GoGyoumeIchiIchiRanEntity> 委員情報リスト;
    private final List<GoGyoumeIchiIchiRanEntity> 調査員情報リスト;
    private final List<GoGyoumeIchiIchiRanEntity> その他情報リスト;
    private final List<RString> 合計数リスト;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護認定審査会議事録のITEM
     */
    public ShinsakaiGijirokuReport(ShinsakaiGijirokuEntity item) {
        this.item = item;
        委員情報リスト = new ArrayList<>();
        調査員情報リスト = new ArrayList<>();
        その他情報リスト = new ArrayList<>();
        合計数リスト = new ArrayList<>();
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiGijirokuReportSource> reportSourceWriter) {
        get委員情報(item);
        List<SanGyoumeYonJyoIchiRanEntity> 新規と更新と区変の件数リスト = get新規と更新と区変の件数(item);
        List<SanGyoumeKuIchiRanEntity> 新規と更新と区変の件数上リスト = get新規と更新と区変毎の件数毎の件数上(item);
        List<SanGyoumeKuIchiRanEntity> 新規と更新と区変の件数下リスト = get新規と更新と区変毎の件数毎の件数下(item);
        ShinsakaiGijirokuEditor editor;
        ShinsakaiGijirokuBodyEditor1 bodyEditor1 = null;
        ShinsakaiGijirokuBodyEditor2 bodyEditor2 = null;
        ShinsakaiGijirokuBodyEditor3 bodyEditor3 = null;
        ShinsakaiGijirokuBodyEditor4 bodyEditor4 = null;
        ShinsakaiGijirokuBodyEditor5 bodyEditor5 = null;
        for (int i = 0; i < INDEX_5; i++) {
            editor = new ShinsakaiGijirokuEditor(item);
            if (i < 2) {
                bodyEditor1 = new ShinsakaiGijirokuBodyEditor1(新規と更新と区変の件数リスト.get(i));
                bodyEditor2 = new ShinsakaiGijirokuBodyEditor2(新規と更新と区変の件数上リスト.get(i));
                bodyEditor3 = new ShinsakaiGijirokuBodyEditor3(新規と更新と区変の件数下リスト.get(i));
                if (i < 委員情報リスト.size()) {
                    bodyEditor4 = new ShinsakaiGijirokuBodyEditor4(委員情報リスト.get(i));
                    bodyEditor5 = new ShinsakaiGijirokuBodyEditor5(合計数リスト.get(i));
                }
            } else if (i == INDEX_2) {
                if (INDEX_1 < 調査員情報リスト.size()) {
                    bodyEditor4 = new ShinsakaiGijirokuBodyEditor4(調査員情報リスト.get(INDEX_1));
                    bodyEditor5 = new ShinsakaiGijirokuBodyEditor5(合計数リスト.get(i));
                }
            } else if (i == INDEX_3) {
                if (INDEX_1 < その他情報リスト.size()) {
                    bodyEditor4 = new ShinsakaiGijirokuBodyEditor4(その他情報リスト.get(INDEX_1));
                    bodyEditor5 = new ShinsakaiGijirokuBodyEditor5(合計数リスト.get(i));
                }
            }
            ShinsakaiGijirokuBuilder builder = new ShinsakaiGijirokuBuilder(editor, bodyEditor1, bodyEditor2, bodyEditor3, bodyEditor4, bodyEditor5);
            reportSourceWriter.writeLine(builder);
        }
    }

    private void get委員情報(ShinsakaiGijirokuEntity item) {
        List<IinJohoRelateEntity> 委員情報リストtemp = new ArrayList<>();
        List<IinJohoRelateEntity> 調査員情報リストtemp = new ArrayList<>();
        List<IinJohoRelateEntity> その他情報リストtemp = new ArrayList<>();
        for (IinJohoRelateEntity entity : item.get委員情報()) {
            if (!Sikaku.ホームヘルパー.getコード().equals(entity.getShinsakaiIinShikakuCode())
                    && !Sikaku.介護職員.getコード().equals(entity.getShinsakaiIinShikakuCode())
                    && !Sikaku.その他.getコード().equals(entity.getShinsakaiIinShikakuCode())) {
                委員情報リストtemp.add(entity);
            } else if (Sikaku.ホームヘルパー.getコード().equals(entity.getShinsakaiIinShikakuCode())
                    || Sikaku.介護職員.getコード().equals(entity.getShinsakaiIinShikakuCode())) {
                調査員情報リストtemp.add(entity);
            } else if (Sikaku.その他.getコード().equals(entity.getShinsakaiIinShikakuCode())) {
                その他情報リストtemp.add(entity);
            }
        }
        List<RString> temp委員リスト = new ArrayList<>();
        for (IinJohoRelateEntity entity : 委員情報リストtemp) {
            RStringBuilder rsb = new RStringBuilder();
            if (new RString(INDEX_1).equals(entity.getKaigoninteiShinsakaiGichoKubunCode())) {
                rsb.append(new RString("◎"));
                rsb.append(entity.getShinsakaiIinShimei());
            } else if (new RString(INDEX_0).equals(entity.getKaigoninteiShinsakaiGichoKubunCode())) {
                rsb.append(entity.getShinsakaiIinShimei());
            }
            temp委員リスト.add(rsb.toRString());
        }
        edit員情報(temp委員リスト);
        edit調査員情報(調査員情報リストtemp);
        editその他情報(その他情報リストtemp);
    }

    private void edit員情報(List<RString> temp委員リスト) {
        if (temp委員リスト.size() >= INDEX_5) {
            合計数リスト.add(new RString(INDEX_5));
            委員情報リスト.add(new GoGyoumeIchiIchiRanEntity(temp委員リスト.get(INDEX_0), temp委員リスト.get(INDEX_1), temp委員リスト.get(INDEX_2),
                    temp委員リスト.get(INDEX_3), temp委員リスト.get(INDEX_4)));
        } else {
            合計数リスト.add(new RString(temp委員リスト.size()));
            合計数リスト.add(new RString(INDEX_0));
            if (temp委員リスト.size() == INDEX_1) {
                委員情報リスト.add(new GoGyoumeIchiIchiRanEntity(temp委員リスト.get(INDEX_0), RString.EMPTY, RString.EMPTY,
                        RString.EMPTY, RString.EMPTY));
            } else if (temp委員リスト.size() == INDEX_2) {
                委員情報リスト.add(new GoGyoumeIchiIchiRanEntity(temp委員リスト.get(INDEX_0),
                        temp委員リスト.get(INDEX_1), RString.EMPTY, RString.EMPTY, RString.EMPTY));
            } else if (temp委員リスト.size() == INDEX_3) {
                委員情報リスト.add(new GoGyoumeIchiIchiRanEntity(temp委員リスト.get(INDEX_0),
                        temp委員リスト.get(INDEX_1), temp委員リスト.get(INDEX_2), RString.EMPTY, RString.EMPTY));
            } else if (temp委員リスト.size() == INDEX_4) {
                委員情報リスト.add(new GoGyoumeIchiIchiRanEntity(temp委員リスト.get(INDEX_0),
                        temp委員リスト.get(INDEX_1), temp委員リスト.get(INDEX_2), temp委員リスト.get(INDEX_3), RString.EMPTY));
            }
            委員情報リスト.add(new GoGyoumeIchiIchiRanEntity(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY));
        }
        if (temp委員リスト.size() > INDEX_5) {
            合計数リスト.add(new RString(temp委員リスト.size() - INDEX_5));
            if (temp委員リスト.size() == INDEX_6) {
                委員情報リスト.add(new GoGyoumeIchiIchiRanEntity(temp委員リスト.get(INDEX_5), RString.EMPTY, RString.EMPTY,
                        RString.EMPTY, RString.EMPTY));
            } else if (temp委員リスト.size() == INDEX_7) {
                委員情報リスト.add(new GoGyoumeIchiIchiRanEntity(temp委員リスト.get(INDEX_5), temp委員リスト.get(INDEX_6),
                        RString.EMPTY, RString.EMPTY, RString.EMPTY));
            } else if (temp委員リスト.size() == INDEX_8) {
                委員情報リスト.add(new GoGyoumeIchiIchiRanEntity(temp委員リスト.get(INDEX_5), temp委員リスト.get(INDEX_6),
                        temp委員リスト.get(INDEX_7), RString.EMPTY, RString.EMPTY));
            } else if (temp委員リスト.size() == INDEX_9) {
                委員情報リスト.add(new GoGyoumeIchiIchiRanEntity(temp委員リスト.get(INDEX_5),
                        temp委員リスト.get(INDEX_6), temp委員リスト.get(INDEX_7), temp委員リスト.get(INDEX_8), RString.EMPTY));
            }
        }
    }

    private void edit調査員情報(List<IinJohoRelateEntity> 調査員情報リストtemp) {
        if (調査員情報リストtemp.size() > INDEX_5) {
            合計数リスト.add(new RString(INDEX_5));
            調査員情報リスト.add(new GoGyoumeIchiIchiRanEntity(調査員情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                    調査員情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                    調査員情報リストtemp.get(INDEX_1).getShinsakaiIinShimei(),
                    調査員情報リストtemp.get(INDEX_2).getShinsakaiIinShimei(),
                    調査員情報リストtemp.get(INDEX_3).getShinsakaiIinShimei()));
        } else {
            合計数リスト.add(new RString(調査員情報リストtemp.size()));
            if (調査員情報リストtemp.size() == INDEX_1) {
                調査員情報リスト.add(new GoGyoumeIchiIchiRanEntity(調査員情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY));
            } else if (調査員情報リストtemp.size() == INDEX_2) {
                調査員情報リスト.add(new GoGyoumeIchiIchiRanEntity(調査員情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                        調査員情報リストtemp.get(INDEX_1).getShinsakaiIinShimei(), RString.EMPTY, RString.EMPTY, RString.EMPTY));
            } else if (調査員情報リストtemp.size() == INDEX_3) {
                調査員情報リスト.add(new GoGyoumeIchiIchiRanEntity(調査員情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                        調査員情報リストtemp.get(INDEX_1).getShinsakaiIinShimei(),
                        調査員情報リストtemp.get(INDEX_2).getShinsakaiIinShimei(), RString.EMPTY, RString.EMPTY));
            } else if (調査員情報リストtemp.size() == INDEX_4) {
                調査員情報リスト.add(new GoGyoumeIchiIchiRanEntity(調査員情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                        調査員情報リストtemp.get(INDEX_1).getShinsakaiIinShimei(), 調査員情報リストtemp.get(INDEX_2).getShinsakaiIinShimei(),
                        調査員情報リストtemp.get(INDEX_3).getShinsakaiIinShimei(), RString.EMPTY));
            }
        }
    }

    private void editその他情報(List<IinJohoRelateEntity> その他情報リストtemp) {
        if (その他情報リストtemp.size() >= INDEX_5) {
            合計数リスト.add(new RString(INDEX_5));
            その他情報リスト.add(new GoGyoumeIchiIchiRanEntity(その他情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                    その他情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                    その他情報リストtemp.get(INDEX_1).getShinsakaiIinShimei(),
                    その他情報リストtemp.get(INDEX_2).getShinsakaiIinShimei(),
                    その他情報リストtemp.get(INDEX_3).getShinsakaiIinShimei()));
        } else {
            合計数リスト.add(new RString(その他情報リストtemp.size()));
            if (その他情報リストtemp.size() == INDEX_1) {
                その他情報リスト.add(new GoGyoumeIchiIchiRanEntity(その他情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY));
            } else if (その他情報リストtemp.size() == INDEX_2) {
                その他情報リスト.add(new GoGyoumeIchiIchiRanEntity(その他情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                        その他情報リストtemp.get(INDEX_1).getShinsakaiIinShimei(), RString.EMPTY, RString.EMPTY, RString.EMPTY));
            } else if (その他情報リストtemp.size() == INDEX_3) {
                その他情報リスト.add(new GoGyoumeIchiIchiRanEntity(その他情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                        その他情報リストtemp.get(INDEX_1).getShinsakaiIinShimei(),
                        その他情報リストtemp.get(INDEX_2).getShinsakaiIinShimei(),
                        RString.EMPTY,
                        RString.EMPTY));
            } else if (その他情報リストtemp.size() == INDEX_4) {
                その他情報リスト.add(new GoGyoumeIchiIchiRanEntity(その他情報リストtemp.get(INDEX_0).getShinsakaiIinShimei(),
                        その他情報リストtemp.get(INDEX_1).getShinsakaiIinShimei(),
                        その他情報リストtemp.get(INDEX_2).getShinsakaiIinShimei(),
                        その他情報リストtemp.get(INDEX_3).getShinsakaiIinShimei(),
                        RString.EMPTY));
            }
        }
    }

    private List<SanGyoumeYonJyoIchiRanEntity> get新規と更新と区変の件数(ShinsakaiGijirokuEntity item) {
        List<SanGyoumeYonJyoIchiRanEntity> resultList = new ArrayList<>();
        ShinsakaiKekkaJohoRelateEntity entity = item.get審査会審査結果等();
        resultList.add(new SanGyoumeYonJyoIchiRanEntity(new RString(entity.get新規申請件数()),
                new RString(entity.get新規_状変の内2号被保険者数()),
                new RString(entity.get新規_状変在宅数()),
                new RString(entity.get新規_状変施設数())));
        resultList.add(new SanGyoumeYonJyoIchiRanEntity(new RString(entity.get更新申請件数()),
                new RString(entity.get更新申請内2号被保険者数()),
                new RString(entity.get新規_状変在宅数()),
                new RString(entity.get新規_状変施設数())));
        resultList.add(new SanGyoumeYonJyoIchiRanEntity(new RString(entity.get判定件数()),
                new RString(entity.get判定件数_2号被保険者数()),
                new RString(entity.get判定件数_在宅数()),
                new RString(entity.get判定件数_施設数())));

        return resultList;
    }

    private List<SanGyoumeKuIchiRanEntity> get新規と更新と区変毎の件数毎の件数上(ShinsakaiGijirokuEntity item) {
        List<SanGyoumeKuIchiRanEntity> resultList = new ArrayList<>();
        ShinsakaiKekkaJohoRelateEntity entity = item.get審査会審査結果等();
        resultList.add(new SanGyoumeKuIchiRanEntity(new RString(entity.get新規_状変一次判定非該当数()),
                new RString(entity.get新規_状変一次判定要支援1数()),
                new RString(entity.get新規_状変一次判定要支援2数()),
                new RString(entity.get新規_状変一次判定要介護1数()),
                new RString(entity.get新規_状変一次判定要介護2数()),
                new RString(entity.get新規_状変一次判定要介護3数()),
                new RString(entity.get新規_状変一次判定要介護4数()),
                new RString(entity.get新規_状変一次判定要介護5数()),
                new RString(entity.get新規_状変一次判定再調査数())));
        resultList.add(new SanGyoumeKuIchiRanEntity(new RString(entity.get更新申請の一次判定非該当数()),
                new RString(entity.get更新申請の一次判定要支援1数()),
                new RString(entity.get更新申請の一次判定要支援2数()),
                new RString(entity.get更新申請の一次判定要介護1数()),
                new RString(entity.get更新申請の一次判定要介護2数()),
                new RString(entity.get更新申請の一次判定要介護3数()),
                new RString(entity.get更新申請の一次判定要介護4数()),
                new RString(entity.get更新申請の一次判定要介護5数()),
                new RString(entity.get更新申請の一次判定再調査数())));
        resultList.add(new SanGyoumeKuIchiRanEntity(new RString(entity.get状変一次判定非該当数()),
                new RString(entity.get状変一次判定要支援1数()),
                new RString(entity.get状変一次判定要支援2数()),
                new RString(entity.get状変一次判定要介護1数()),
                new RString(entity.get状変一次判定要介護2数()),
                new RString(entity.get状変一次判定要介護3数()),
                new RString(entity.get状変一次判定要介護4数()),
                new RString(entity.get状変一次判定要介護5数()),
                new RString(entity.get状変一次判定再調査数())));
        return resultList;
    }

    private List<SanGyoumeKuIchiRanEntity> get新規と更新と区変毎の件数毎の件数下(ShinsakaiGijirokuEntity item) {
        List<SanGyoumeKuIchiRanEntity> resultList = new ArrayList<>();
        ShinsakaiKekkaJohoRelateEntity entity = item.get審査会審査結果等();
        resultList.add(new SanGyoumeKuIchiRanEntity(new RString(entity.get新規_状変一次判定非該当数_2号被保険者()),
                new RString(entity.get新規_状変一次判定要支援1数_2号被保険者()),
                new RString(entity.get新規_状変一次判定要支援2数_2号被保険者()),
                new RString(entity.get新規_状変一次判定要介護1数_2号被保険者()),
                new RString(entity.get新規_状変一次判定要介護2数_2号被保険者()),
                new RString(entity.get新規_状変一次判定要介護3数_2号被保険者()),
                new RString(entity.get新規_状変一次判定要介護4数_2号被保険者()),
                new RString(entity.get新規_状変一次判定要介護5数_2号被保険者()),
                new RString(entity.get新規_状変の一次判定再調査数_2号被保険者())));
        resultList.add(new SanGyoumeKuIchiRanEntity(new RString(entity.get更新申請の一次判定非該当数_2号被保険者()),
                new RString(entity.get更新申請の一次判定要支援1数_2号被保険者()),
                new RString(entity.get更新申請の一次判定要支援2数_2号被保険者()),
                new RString(entity.get更新申請の一次判定要介護1数_2号被保険者()),
                new RString(entity.get更新申請の一次判定要介護2数_2号被保険者()),
                new RString(entity.get更新申請の一次判定要介護3数_2号被保険者()),
                new RString(entity.get更新申請の一次判定要介護4数_2号被保険者()),
                new RString(entity.get更新申請の一次判定要介護5数_2号被保険者()),
                new RString(entity.get更新申請の一次判定再調査数_2号被保険者())));
        resultList.add(new SanGyoumeKuIchiRanEntity(new RString(entity.get状変一次判定非該当数_2号被保険者()),
                new RString(entity.get状変一次判定要支援1数_2号被保険者()),
                new RString(entity.get状変一次判定要支援2数_2号被保険者()),
                new RString(entity.get状変一次判定要介護1数_2号被保険者()),
                new RString(entity.get状変一次判定要介護2数_2号被保険者()),
                new RString(entity.get状変一次判定要介護3数_2号被保険者()),
                new RString(entity.get状変一次判定要介護4数_2号被保険者()),
                new RString(entity.get状変一次判定要介護5数_2号被保険者()),
                new RString(entity.get状変の一次判定再調査数_2号被保険者())));
        return resultList;
    }

}
