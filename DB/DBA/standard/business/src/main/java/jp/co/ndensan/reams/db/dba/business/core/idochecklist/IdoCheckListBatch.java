/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.idochecklist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.idochecklist.IdoCheckListItem;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.IdoCheckListEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.IdoInfoEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 異動チェックリスト帳票用データを作成Businessクラスです。
 *
 * @reamsid_L DBA-0530-040 chengsanyuan
 *
 */
public class IdoCheckListBatch {

    private static final RString FUSEIGO_COUNT_TITLE = new RString("不整合合計数：");
    private static final RString DATA_NAI = new RString("該当データがありません");

    /**
     * 被保険者台帳帳票用データを作成します。
     *
     * @param idoCheckListEntity 異動チェックリスト
     * @return 被保険者台帳帳票用データ
     */
    public List<IdoCheckListItem> getIdoCheckChohyoData(IdoCheckListEntity idoCheckListEntity) {
        List<IdoCheckListItem> retList = new ArrayList<>();
        List<IdoInfoEntity> list = idoCheckListEntity.getIdoInfoList();
        int k = 1;
        for (IdoInfoEntity entity : list) {
            if (entity.get識別コード() == null || entity.get識別コード().isEmpty()) {
                IdoCheckListItem item = new IdoCheckListItem(
                        getNowDate(),
                        new RString(String.valueOf(k)),
                        entity.get対象情報タイトル(),
                        idoCheckListEntity.get市町村コード().value(),
                        idoCheckListEntity.get市町村名(),
                        new RString(String.valueOf(idoCheckListEntity.get並び順１())),
                        new RString(String.valueOf(idoCheckListEntity.get並び順２())),
                        new RString(String.valueOf(idoCheckListEntity.get並び順３())),
                        new RString(String.valueOf(idoCheckListEntity.get並び順４())),
                        new RString(String.valueOf(idoCheckListEntity.get並び順５())),
                        entity.get改頁１(),
                        entity.get改頁２(),
                        entity.get改頁３(),
                        entity.get改頁４(),
                        entity.get改頁５(),
                        entity.get開始タイトル(),
                        entity.get終了タイトル(),
                        entity.get区分タイトル(),
                        entity.get異動情報タイトル1(),
                        entity.get異動情報タイトル2(),
                        entity.get異動情報タイトル3(),
                        entity.get開始年月日タイトル(),
                        entity.get終了年月日タイトル(),
                        entity.get異動情報タイトル4(),
                        entity.get異動情報タイトル5(),
                        entity.get異動情報タイトル6(),
                        entity.get世帯コード().value(),
                        entity.get被保険者カナ氏名().value(),
                        entity.get取得情報_前_事由(),
                        flexToRstr(entity.get取得情報_前_異動年月日()),
                        flexToRstr(entity.get取得情報_前_届出年月日()),
                        flexToRstr(entity.get開始年月日データ_前()),
                        entity.get喪失情報_前_事由(),
                        flexToRstr(entity.get喪失情報_前_異動年月日()),
                        flexToRstr(entity.get喪失情報_前_届出年月日()),
                        flexToRstr(entity.get終了年月日データ_前()),
                        entity.get区分_前_資格(),
                        entity.get異動情報データ1(),
                        entity.get異動情報データ2(),
                        entity.get異動情報データ3(),
                        entity.get被保険者番号(),
                        entity.get識別コード().value(),
                        DATA_NAI,
                        entity.get取得情報_後_事由(),
                        flexToRstr(entity.get取得情報_後_異動年月日()),
                        flexToRstr(entity.get取得情報_後_届出年月日()),
                        flexToRstr(entity.get開始年月日データ_後()),
                        entity.get喪失情報_後_事由(),
                        flexToRstr(entity.get喪失情報_後_異動年月日()),
                        flexToRstr(entity.get喪失情報_後_届出年月日()),
                        flexToRstr(entity.get終了年月日データ_後()),
                        entity.get区分_後_資格(),
                        entity.get異動情報データ4(),
                        entity.get異動情報データ5(),
                        entity.get異動情報データ6(),
                        FUSEIGO_COUNT_TITLE,
                        new RString(String.valueOf(list.size())));
                retList.add(item);
            } else {
                IdoCheckListItem item = new IdoCheckListItem(
                        getNowDate(),
                        new RString(String.valueOf(k)),
                        entity.get対象情報タイトル(),
                        idoCheckListEntity.get市町村コード().value(),
                        idoCheckListEntity.get市町村名(),
                        new RString(String.valueOf(idoCheckListEntity.get並び順１())),
                        new RString(String.valueOf(idoCheckListEntity.get並び順２())),
                        new RString(String.valueOf(idoCheckListEntity.get並び順３())),
                        new RString(String.valueOf(idoCheckListEntity.get並び順４())),
                        new RString(String.valueOf(idoCheckListEntity.get並び順５())),
                        entity.get改頁１(),
                        entity.get改頁２(),
                        entity.get改頁３(),
                        entity.get改頁４(),
                        entity.get改頁５(),
                        entity.get開始タイトル(),
                        entity.get終了タイトル(),
                        entity.get区分タイトル(),
                        entity.get異動情報タイトル1(),
                        entity.get異動情報タイトル2(),
                        entity.get異動情報タイトル3(),
                        entity.get開始年月日タイトル(),
                        entity.get終了年月日タイトル(),
                        entity.get異動情報タイトル4(),
                        entity.get異動情報タイトル5(),
                        entity.get異動情報タイトル6(),
                        entity.get世帯コード().value(),
                        entity.get被保険者カナ氏名().value(),
                        entity.get取得情報_前_事由(),
                        flexToRstr(entity.get取得情報_前_異動年月日()),
                        flexToRstr(entity.get取得情報_前_届出年月日()),
                        flexToRstr(entity.get開始年月日データ_前()),
                        entity.get喪失情報_前_事由(),
                        flexToRstr(entity.get喪失情報_前_異動年月日()),
                        flexToRstr(entity.get喪失情報_前_届出年月日()),
                        flexToRstr(entity.get終了年月日データ_前()),
                        entity.get区分_前_資格(),
                        entity.get異動情報データ1(),
                        entity.get異動情報データ2(),
                        entity.get異動情報データ3(),
                        entity.get被保険者番号(),
                        entity.get識別コード().value(),
                        entity.get被保険者氏名().value(),
                        entity.get取得情報_後_事由(),
                        flexToRstr(entity.get取得情報_後_異動年月日()),
                        flexToRstr(entity.get取得情報_後_届出年月日()),
                        flexToRstr(entity.get開始年月日データ_後()),
                        entity.get喪失情報_後_事由(),
                        flexToRstr(entity.get喪失情報_後_異動年月日()),
                        flexToRstr(entity.get喪失情報_後_届出年月日()),
                        flexToRstr(entity.get終了年月日データ_後()),
                        entity.get区分_後_資格(),
                        entity.get異動情報データ4(),
                        entity.get異動情報データ5(),
                        entity.get異動情報データ6(),
                        FUSEIGO_COUNT_TITLE,
                        new RString(String.valueOf(list.size())));
                retList.add(item);
            }
            k = k + 1;
        }
        return retList;
    }

    private RString getNowDate() {
        RStringBuilder rsb = new RStringBuilder();
        RTime nowTime = RTime.now();
        RDate nowDate = RDate.getNowDate();
        rsb.append(nowDate.wareki().eraType(EraType.KANJI).getYear());
        rsb.append(new RString("年"));
        rsb.append(nowDate.getMonthValue());
        rsb.append(new RString("月"));
        rsb.append(nowDate.getDayValue());
        rsb.append(new RString("日"));
        rsb.append(RString.HALF_SPACE);
        rsb.append(nowTime.getHour());
        rsb.append(new RString("時"));
        rsb.append(nowTime.getMinute());
        rsb.append(new RString("分"));
        rsb.append(nowTime.getSecond());
        rsb.append(new RString("秒"));
        return rsb.toRString();
    }

    private RString flexToRstr(FlexibleDate date) {
        if (date != null && !date.isEmpty()) {
            return date.wareki().separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }
}
