/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jukirendotorokushalist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist.JukiRendoTorokuListItem;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.JyukiRendoJouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.JyukiRendoTorokushaListBatchEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity.JyukiRendoTorokushaListTyouHyouListEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票データ作成クラス。
 *
 * @reamsid_L DBA-0560-040 xuyannan
 */
public class JyukiRendoTorokushaListBatch {

    private static final RString 被保険者氏名 = new RString("該当データがありません");
    private static final RString 号 = new RString(" 号");

    /**
     * 帳票データを作成します。
     *
     * @param entity 住基連動登録者リストEntity
     * @return JyukiRendoTorokushaListTyouHyouListEntity
     */
    public List<JukiRendoTorokuListItem> getIdoCheckChohyoData(
            JyukiRendoTorokushaListBatchEntity entity) {
        List<JukiRendoTorokuListItem> list = new ArrayList();
        RStringBuilder リスト上_区分Builder = new RStringBuilder();
        RStringBuilder リスト下_区分Builder = new RStringBuilder();
        for (JyukiRendoJouhouEntity jyukiRendoJouhouEntity : entity.get住基連動情報()) {
            JyukiRendoTorokushaListTyouHyouListEntity tyouHyouListEntity
                    = new JyukiRendoTorokushaListTyouHyouListEntity();
            tyouHyouListEntity.set印刷日時(get印刷日時());
            tyouHyouListEntity.set市町村コード(new RString(entity.get市町村コード().toString()));
            tyouHyouListEntity.set市町村名(entity.get市町村名());
            tyouHyouListEntity.set並び順１(entity.get並び順_1());
            tyouHyouListEntity.set並び順２(entity.get並び順_2());
            tyouHyouListEntity.set並び順３(entity.get並び順_3());
            tyouHyouListEntity.set並び順４(entity.get並び順_4());
            tyouHyouListEntity.set並び順５(entity.get並び順_5());
            tyouHyouListEntity.set改頁１(entity.get改頁_1());
            tyouHyouListEntity.set改頁２(entity.get改頁_2());
            tyouHyouListEntity.set改頁３(entity.get改頁_3());
            tyouHyouListEntity.set改頁４(entity.get改頁_4());
            tyouHyouListEntity.set改頁５(entity.get改頁_5());
            tyouHyouListEntity.set抽出期間F(entity.get抽出期間F());
            tyouHyouListEntity.set抽出期間T(entity.get抽出期間T());
            if (jyukiRendoJouhouEntity.get識別コード() == null) {
                set帳票データ作成用Entityの部分項目(tyouHyouListEntity, jyukiRendoJouhouEntity);
                tyouHyouListEntity.setリスト下_被保険者氏名(被保険者氏名);
            } else {
                set帳票データ作成用Entityの部分項目(tyouHyouListEntity, jyukiRendoJouhouEntity);
                if (jyukiRendoJouhouEntity.get被保険者氏名() != null) {
                    tyouHyouListEntity.setリスト下_被保険者氏名(jyukiRendoJouhouEntity.get被保険者氏名().value());
                }
            }
            リスト上_区分Builder.delete(0, リスト上_区分Builder.length());
            リスト下_区分Builder.delete(0, リスト下_区分Builder.length());
            if (RString.isNullOrEmpty(tyouHyouListEntity.getリスト上_区分())) {
                リスト上_区分Builder.append(RString.EMPTY);
            } else {
                リスト上_区分Builder.append(tyouHyouListEntity.getリスト上_区分());
                リスト上_区分Builder.append(号);
            }
            if (RString.isNullOrEmpty(tyouHyouListEntity.getリスト下_区分())) {
                リスト下_区分Builder.append(RString.EMPTY);
            } else {
                リスト下_区分Builder.append(tyouHyouListEntity.getリスト下_区分());
                リスト下_区分Builder.append(号);
            }
            tyouHyouListEntity.setリスト上_区分(リスト上_区分Builder.toRString());
            tyouHyouListEntity.setリスト下_区分(リスト下_区分Builder.toRString());

            JukiRendoTorokuListItem jukiRendoTorokuListItem = new JukiRendoTorokuListItem(
                    tyouHyouListEntity.get印刷日時(),
                    tyouHyouListEntity.get対象情報タイトル(),
                    tyouHyouListEntity.get市町村コード(),
                    tyouHyouListEntity.get市町村名(),
                    tyouHyouListEntity.get並び順１(),
                    tyouHyouListEntity.get並び順２(),
                    tyouHyouListEntity.get並び順３(),
                    tyouHyouListEntity.get並び順４(),
                    tyouHyouListEntity.get並び順５(),
                    tyouHyouListEntity.get改頁１(),
                    tyouHyouListEntity.get改頁２(),
                    tyouHyouListEntity.get改頁３(),
                    tyouHyouListEntity.get改頁４(),
                    tyouHyouListEntity.get改頁５(),
                    tyouHyouListEntity.get開始タイトル(),
                    tyouHyouListEntity.get終了タイトル(),
                    tyouHyouListEntity.get区分タイトル(),
                    tyouHyouListEntity.get異動情報タイトル1(),
                    tyouHyouListEntity.get異動情報タイトル2(),
                    tyouHyouListEntity.get異動情報タイトル3(),
                    tyouHyouListEntity.get開始年月日タイトル(),
                    tyouHyouListEntity.get終了年月日タイトル(),
                    tyouHyouListEntity.get異動情報タイトル4(),
                    tyouHyouListEntity.get異動情報タイトル5(),
                    tyouHyouListEntity.get異動情報タイトル6(),
                    tyouHyouListEntity.getリスト上_世帯コード(),
                    tyouHyouListEntity.getリスト上_被保険者カナ氏名(),
                    tyouHyouListEntity.getリスト上_事由(),
                    tyouHyouListEntity.getリスト上_異動年月日(),
                    tyouHyouListEntity.getリスト上_届出年月日(),
                    tyouHyouListEntity.getリスト上_開始年月日(),
                    tyouHyouListEntity.getリスト上_事由_2(),
                    tyouHyouListEntity.getリスト上_異動年月日_2(),
                    tyouHyouListEntity.getリスト上_届出年月日_2(),
                    tyouHyouListEntity.getリスト上_終了年月日(),
                    tyouHyouListEntity.getリスト上_区分(),
                    tyouHyouListEntity.getリスト上_異動情報1(),
                    tyouHyouListEntity.getリスト上_異動情報2(),
                    tyouHyouListEntity.getリスト上_異動情報3(),
                    tyouHyouListEntity.getリスト_被保険者番号(),
                    tyouHyouListEntity.getリスト下_識別コード(),
                    tyouHyouListEntity.getリスト下_被保険者氏名(),
                    tyouHyouListEntity.getリスト下_事由(),
                    tyouHyouListEntity.getリスト下_異動年月日(),
                    tyouHyouListEntity.getリスト下_届出年月日(),
                    tyouHyouListEntity.getリスト下_開始年月日(),
                    tyouHyouListEntity.getリスト下_事由_2(),
                    tyouHyouListEntity.getリスト下_異動年月日_2(),
                    tyouHyouListEntity.getリスト下_届出年月日_2(),
                    tyouHyouListEntity.getリスト下_終了年月日(),
                    tyouHyouListEntity.getリスト下_区分(),
                    tyouHyouListEntity.getリスト下_異動情報4(),
                    tyouHyouListEntity.getリスト下_異動情報5(),
                    tyouHyouListEntity.getリスト下_異動情報6(),
                    tyouHyouListEntity.get抽出期間F(),
                    tyouHyouListEntity.get抽出期間T()
            );
            list.add(jukiRendoTorokuListItem);
        }
        return list;
    }

    private void set帳票データ作成用Entityの部分項目(
            JyukiRendoTorokushaListTyouHyouListEntity tyouHyouListEntity,
            JyukiRendoJouhouEntity jyukiRendoJouhouEntity) {
        tyouHyouListEntity.set対象情報タイトル(jyukiRendoJouhouEntity.get対象情報タイトル());
        tyouHyouListEntity.set開始タイトル(jyukiRendoJouhouEntity.get開始タイトル());
        tyouHyouListEntity.set終了タイトル(jyukiRendoJouhouEntity.get終了タイトル());
        tyouHyouListEntity.set区分タイトル(jyukiRendoJouhouEntity.get区分タイトル());
        tyouHyouListEntity.set異動情報タイトル1(jyukiRendoJouhouEntity.get異動情報タイトル1());
        tyouHyouListEntity.set異動情報タイトル2(jyukiRendoJouhouEntity.get異動情報タイトル2());
        tyouHyouListEntity.set異動情報タイトル3(jyukiRendoJouhouEntity.get異動情報タイトル3());
        tyouHyouListEntity.set開始年月日タイトル(jyukiRendoJouhouEntity.get開始年月日タイトル());
        tyouHyouListEntity.set終了年月日タイトル(jyukiRendoJouhouEntity.get終了年月日タイトル());
        tyouHyouListEntity.set異動情報タイトル4(jyukiRendoJouhouEntity.get異動情報タイトル4());
        tyouHyouListEntity.set異動情報タイトル5(jyukiRendoJouhouEntity.get異動情報タイトル5());
        tyouHyouListEntity.set異動情報タイトル6(jyukiRendoJouhouEntity.get異動情報タイトル6());
        if (jyukiRendoJouhouEntity.get世帯コード() != null) {
            tyouHyouListEntity.setリスト上_世帯コード(jyukiRendoJouhouEntity.get世帯コード().value());
        }
        if (jyukiRendoJouhouEntity.get被保険者カナ氏名() != null) {
            tyouHyouListEntity.setリスト上_被保険者カナ氏名(jyukiRendoJouhouEntity.get被保険者カナ氏名().value());
        }
        tyouHyouListEntity.setリスト上_事由(jyukiRendoJouhouEntity.get取得情報_前_事由());
        if (jyukiRendoJouhouEntity.get取得情報_前_異動年月日() != null) {
            tyouHyouListEntity.setリスト上_異動年月日(
                    jyukiRendoJouhouEntity.get取得情報_前_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get取得情報_前_届出年月日() != null) {
            tyouHyouListEntity.setリスト上_届出年月日(
                    jyukiRendoJouhouEntity.get取得情報_前_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get開始年月日データ_前() != null) {
            tyouHyouListEntity.setリスト上_開始年月日(
                    jyukiRendoJouhouEntity.get開始年月日データ_前()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        tyouHyouListEntity.setリスト上_事由_2(jyukiRendoJouhouEntity.get喪失情報_前_事由());
        if (jyukiRendoJouhouEntity.get喪失情報_前_異動年月日() != null) {
            tyouHyouListEntity.setリスト上_異動年月日_2(
                    jyukiRendoJouhouEntity.get喪失情報_前_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get喪失情報_前_届出年月日() != null) {
            tyouHyouListEntity.setリスト上_届出年月日_2(
                    jyukiRendoJouhouEntity.get喪失情報_前_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get終了年月日データ_前() != null) {
            tyouHyouListEntity.setリスト上_終了年月日(
                    jyukiRendoJouhouEntity.get終了年月日データ_前()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        tyouHyouListEntity.setリスト上_区分(jyukiRendoJouhouEntity.get区分_前_資格());
        tyouHyouListEntity.setリスト上_異動情報1(jyukiRendoJouhouEntity.get異動情報データ1());
        tyouHyouListEntity.setリスト上_異動情報2(jyukiRendoJouhouEntity.get異動情報データ2());
        tyouHyouListEntity.setリスト上_異動情報3(jyukiRendoJouhouEntity.get異動情報データ3());
        if (jyukiRendoJouhouEntity.get被保険者番号() != null) {
            tyouHyouListEntity.setリスト_被保険者番号(jyukiRendoJouhouEntity.get被保険者番号().value());
        }
        if (jyukiRendoJouhouEntity.get識別コード() != null) {
            tyouHyouListEntity.setリスト下_識別コード(jyukiRendoJouhouEntity.get識別コード().value());
        }
        tyouHyouListEntity.setリスト下_事由(jyukiRendoJouhouEntity.get取得情報_後_事由());
        if (jyukiRendoJouhouEntity.get取得情報_後_異動年月日() != null) {
            tyouHyouListEntity.setリスト下_異動年月日(
                    jyukiRendoJouhouEntity.get取得情報_後_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get取得情報_後_届出年月日() != null) {
            tyouHyouListEntity.setリスト下_届出年月日(
                    jyukiRendoJouhouEntity.get取得情報_後_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get開始年月日データ_後() != null) {
            tyouHyouListEntity.setリスト下_開始年月日(
                    jyukiRendoJouhouEntity.get開始年月日データ_後()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        tyouHyouListEntity.setリスト下_事由_2(jyukiRendoJouhouEntity.get喪失情報_後_事由());
        if (jyukiRendoJouhouEntity.get喪失情報_後_異動年月日() != null) {
            tyouHyouListEntity.setリスト下_異動年月日_2(
                    jyukiRendoJouhouEntity.get喪失情報_後_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get喪失情報_後_届出年月日() != null) {
            tyouHyouListEntity.setリスト下_届出年月日_2(
                    jyukiRendoJouhouEntity.get喪失情報_後_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get終了年月日データ_後() != null) {
            tyouHyouListEntity.setリスト下_終了年月日(
                    jyukiRendoJouhouEntity.get終了年月日データ_後()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        tyouHyouListEntity.setリスト下_区分(jyukiRendoJouhouEntity.get区分_後_資格());
        tyouHyouListEntity.setリスト下_異動情報4(jyukiRendoJouhouEntity.get異動情報データ4());
        tyouHyouListEntity.setリスト下_異動情報5(jyukiRendoJouhouEntity.get異動情報データ5());
        tyouHyouListEntity.setリスト下_異動情報6(jyukiRendoJouhouEntity.get異動情報データ6());
    }

    private static RString get印刷日時() {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%2d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%2d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%2d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        return systemDateTime.toRString();
    }
}
