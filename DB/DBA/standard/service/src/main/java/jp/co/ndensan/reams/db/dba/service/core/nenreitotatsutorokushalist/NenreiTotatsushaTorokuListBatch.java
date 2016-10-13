/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.nenreitotatsutorokushalist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsukakuninlist.NenreitotatsuKakuninListItem;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha.NenreiTotatsuTorokushaListEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha.NenreiTotatsuTorokushaListTyouHyouListEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha.NenreiTotatsushaJouhouEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 年齢到達登録者リスト帳票用データ作成クラス。
 *
 * @reamsid_L DBA-0570-040 xuyannan
 */
public class NenreiTotatsushaTorokuListBatch {

    private static final RString 被保険者氏名 = new RString("該当データがありません");
    private static final RString 号 = new RString(" 号");

    /**
     * 帳票データを作成します。
     *
     * @param entity 年齢到達登録者リストEntity
     * @return NenreiTotatsuTorokushaListTyouHyouListEntity
     */
    public List<NenreitotatsuKakuninListItem> getNenreiTotatsushaTorokuChohyoData(
            NenreiTotatsuTorokushaListEntity entity) {
        List<NenreitotatsuKakuninListItem> list = new ArrayList();
        RStringBuilder リスト上_区分Builder = new RStringBuilder();
        RStringBuilder リスト下_区分Builder = new RStringBuilder();
        for (NenreiTotatsushaJouhouEntity nenreiTotatsushaJouhouEntity : entity.get年齢到達者情報()) {
            NenreiTotatsuTorokushaListTyouHyouListEntity tyouHyouListEntity
                    = new NenreiTotatsuTorokushaListTyouHyouListEntity();
            tyouHyouListEntity.set印刷日時(get印刷日時());
            tyouHyouListEntity.set市町村コード(new RString(entity.get市町村コード().toString()));
            tyouHyouListEntity.set市町村名(entity.get市町村名());
            tyouHyouListEntity.set並び順１(entity.get並び順_1());
            tyouHyouListEntity.set並び順２(entity.get並び順_2());
            tyouHyouListEntity.set並び順３(entity.get並び順_3());
            tyouHyouListEntity.set並び順４(entity.get並び順_4());
            tyouHyouListEntity.set並び順５(entity.get並び順_5());
            tyouHyouListEntity.set改頁１(entity.get改頁１());
            tyouHyouListEntity.set改頁２(entity.get改頁２());
            tyouHyouListEntity.set改頁３(entity.get改頁３());
            tyouHyouListEntity.set改頁４(entity.get改頁４());
            tyouHyouListEntity.set改頁５(entity.get改頁５());
            tyouHyouListEntity.set抽出期間From(entity.get抽出期間From());
            tyouHyouListEntity.set抽出期間To(entity.get抽出期間To());
            if (nenreiTotatsushaJouhouEntity.get識別コード() == null) {
                set帳票データ作成用Entityの部分項目(tyouHyouListEntity, nenreiTotatsushaJouhouEntity);
                tyouHyouListEntity.setリスト下_被保険者氏名(被保険者氏名);
            } else {
                set帳票データ作成用Entityの部分項目(tyouHyouListEntity, nenreiTotatsushaJouhouEntity);
                if (nenreiTotatsushaJouhouEntity.get被保険者氏名() != null) {
                    tyouHyouListEntity.setリスト下_被保険者氏名(nenreiTotatsushaJouhouEntity.get被保険者氏名().value());
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

            NenreitotatsuKakuninListItem nenreitotatsuKakuninListItem = new NenreitotatsuKakuninListItem(
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
                    tyouHyouListEntity.get抽出期間From(),
                    tyouHyouListEntity.get抽出期間To(),
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
                    tyouHyouListEntity.getリスト上_事由_左(),
                    tyouHyouListEntity.getリスト上_異動年月日_左(),
                    tyouHyouListEntity.getリスト上_届出年月日_左(),
                    tyouHyouListEntity.getリスト上_開始年月日(),
                    tyouHyouListEntity.getリスト上_事由_右(),
                    tyouHyouListEntity.getリスト上_異動年月日_右(),
                    tyouHyouListEntity.getリスト上_届出年月日_右(),
                    tyouHyouListEntity.getリスト上_終了年月日(),
                    tyouHyouListEntity.getリスト上_区分(),
                    tyouHyouListEntity.getリスト上_異動情報1(),
                    tyouHyouListEntity.getリスト上_異動情報2(),
                    tyouHyouListEntity.getリスト上_異動情報3(),
                    tyouHyouListEntity.getリスト_被保険者番号(),
                    tyouHyouListEntity.getリスト下_識別コード(),
                    tyouHyouListEntity.getリスト下_被保険者氏名(),
                    tyouHyouListEntity.getリスト下_事由_左(),
                    tyouHyouListEntity.getリスト下_異動年月日_左(),
                    tyouHyouListEntity.getリスト下_届出年月日_左(),
                    tyouHyouListEntity.getリスト下_開始年月日(),
                    tyouHyouListEntity.getリスト下_事由_右(),
                    tyouHyouListEntity.getリスト下_異動年月日_右(),
                    tyouHyouListEntity.getリスト下_届出年月日_右(),
                    tyouHyouListEntity.getリスト下_終了年月日(),
                    tyouHyouListEntity.getリスト下_区分(),
                    tyouHyouListEntity.getリスト下_異動情報4(),
                    tyouHyouListEntity.getリスト下_異動情報5(),
                    tyouHyouListEntity.getリスト下_異動情報6());
            list.add(nenreitotatsuKakuninListItem);
        }
        return list;
    }

    private void set帳票データ作成用Entityの部分項目(
            NenreiTotatsuTorokushaListTyouHyouListEntity tyouHyouListEntity,
            NenreiTotatsushaJouhouEntity nenreiTotatsushaJouhouEntity) {
        tyouHyouListEntity.set対象情報タイトル(nenreiTotatsushaJouhouEntity.get対象情報タイトル());
        tyouHyouListEntity.set開始タイトル(nenreiTotatsushaJouhouEntity.get開始タイトル());
        tyouHyouListEntity.set終了タイトル(nenreiTotatsushaJouhouEntity.get終了タイトル());
        tyouHyouListEntity.set区分タイトル(nenreiTotatsushaJouhouEntity.get区分タイトル());
        tyouHyouListEntity.set異動情報タイトル1(nenreiTotatsushaJouhouEntity.get異動情報タイトル1());
        tyouHyouListEntity.set異動情報タイトル2(nenreiTotatsushaJouhouEntity.get異動情報タイトル2());
        tyouHyouListEntity.set異動情報タイトル3(nenreiTotatsushaJouhouEntity.get異動情報タイトル3());
        tyouHyouListEntity.set開始年月日タイトル(nenreiTotatsushaJouhouEntity.get開始年月日タイトル());
        tyouHyouListEntity.set終了年月日タイトル(nenreiTotatsushaJouhouEntity.get終了年月日タイトル());
        tyouHyouListEntity.set異動情報タイトル4(nenreiTotatsushaJouhouEntity.get異動情報タイトル4());
        tyouHyouListEntity.set異動情報タイトル5(nenreiTotatsushaJouhouEntity.get異動情報タイトル5());
        tyouHyouListEntity.set異動情報タイトル6(nenreiTotatsushaJouhouEntity.get異動情報タイトル6());
        if (nenreiTotatsushaJouhouEntity.get世帯コード() != null) {
            tyouHyouListEntity.setリスト上_世帯コード(nenreiTotatsushaJouhouEntity.get世帯コード().value());
        }
        if (nenreiTotatsushaJouhouEntity.get被保険者カナ氏名() != null) {
            tyouHyouListEntity.setリスト上_被保険者カナ氏名(nenreiTotatsushaJouhouEntity.get被保険者カナ氏名().value());
        }
        tyouHyouListEntity.setリスト上_事由_左(nenreiTotatsushaJouhouEntity.get取得情報_前_事由());
        if (nenreiTotatsushaJouhouEntity.get取得情報_前_異動年月日() != null) {
            tyouHyouListEntity.setリスト上_異動年月日_左(
                    nenreiTotatsushaJouhouEntity.get取得情報_前_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (nenreiTotatsushaJouhouEntity.get取得情報_前_届出年月日() != null) {
            tyouHyouListEntity.setリスト上_届出年月日_左(
                    nenreiTotatsushaJouhouEntity.get取得情報_前_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (nenreiTotatsushaJouhouEntity.get開始年月日データ_前() != null) {
            tyouHyouListEntity.setリスト上_開始年月日(
                    nenreiTotatsushaJouhouEntity.get開始年月日データ_前()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        tyouHyouListEntity.setリスト上_事由_右(nenreiTotatsushaJouhouEntity.get喪失情報_前_事由());
        if (nenreiTotatsushaJouhouEntity.get喪失情報_前_異動年月日() != null) {
            tyouHyouListEntity.setリスト上_異動年月日_右(
                    nenreiTotatsushaJouhouEntity.get喪失情報_前_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (nenreiTotatsushaJouhouEntity.get喪失情報_前_届出年月日() != null) {
            tyouHyouListEntity.setリスト上_届出年月日_右(
                    nenreiTotatsushaJouhouEntity.get喪失情報_前_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (nenreiTotatsushaJouhouEntity.get終了年月日データ_前() != null) {
            tyouHyouListEntity.setリスト上_終了年月日(
                    nenreiTotatsushaJouhouEntity.get終了年月日データ_前()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        tyouHyouListEntity.setリスト上_区分(nenreiTotatsushaJouhouEntity.get区分_前_資格());
        tyouHyouListEntity.setリスト上_異動情報1(nenreiTotatsushaJouhouEntity.get異動情報データ1());
        tyouHyouListEntity.setリスト上_異動情報2(nenreiTotatsushaJouhouEntity.get異動情報データ2());
        tyouHyouListEntity.setリスト上_異動情報3(nenreiTotatsushaJouhouEntity.get異動情報データ3());
        if (nenreiTotatsushaJouhouEntity.get被保険者番号() != null) {
            tyouHyouListEntity.setリスト_被保険者番号(nenreiTotatsushaJouhouEntity.get被保険者番号().value());
        }
        if (nenreiTotatsushaJouhouEntity.get識別コード() != null) {
            tyouHyouListEntity.setリスト下_識別コード(nenreiTotatsushaJouhouEntity.get識別コード().value());
        }
        tyouHyouListEntity.setリスト下_事由_左(nenreiTotatsushaJouhouEntity.get取得情報_後_事由());
        if (nenreiTotatsushaJouhouEntity.get取得情報_後_異動年月日() != null) {
            tyouHyouListEntity.setリスト下_異動年月日_左(
                    nenreiTotatsushaJouhouEntity.get取得情報_後_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (nenreiTotatsushaJouhouEntity.get取得情報_後_届出年月日() != null) {
            tyouHyouListEntity.setリスト下_届出年月日_左(
                    nenreiTotatsushaJouhouEntity.get取得情報_後_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (nenreiTotatsushaJouhouEntity.get開始年月日データ_後() != null) {
            tyouHyouListEntity.setリスト下_開始年月日(
                    nenreiTotatsushaJouhouEntity.get開始年月日データ_後()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        tyouHyouListEntity.setリスト下_事由_右(nenreiTotatsushaJouhouEntity.get喪失情報_後_事由());
        if (nenreiTotatsushaJouhouEntity.get喪失情報_後_異動年月日() != null) {
            tyouHyouListEntity.setリスト下_異動年月日_右(
                    nenreiTotatsushaJouhouEntity.get喪失情報_後_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (nenreiTotatsushaJouhouEntity.get喪失情報_後_届出年月日() != null) {
            tyouHyouListEntity.setリスト下_届出年月日_右(
                    nenreiTotatsushaJouhouEntity.get喪失情報_後_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (nenreiTotatsushaJouhouEntity.get終了年月日データ_後() != null) {
            tyouHyouListEntity.setリスト下_終了年月日(
                    nenreiTotatsushaJouhouEntity.get終了年月日データ_後()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        tyouHyouListEntity.setリスト下_区分(nenreiTotatsushaJouhouEntity.get区分_後_資格());
        tyouHyouListEntity.setリスト下_異動情報4(nenreiTotatsushaJouhouEntity.get異動情報データ4());
        tyouHyouListEntity.setリスト下_異動情報5(nenreiTotatsushaJouhouEntity.get異動情報データ5());
        tyouHyouListEntity.setリスト下_異動情報6(nenreiTotatsushaJouhouEntity.get異動情報データ6());
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
