/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.jukirendotorokushalist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.jyukirendotorokushalistbatchentity.JukiRendoTorokuListItem;
import jp.co.ndensan.reams.db.dba.entity.jyukirendotorokushalistbatchentity.JyukiRendoJouhouEntity;
import jp.co.ndensan.reams.db.dba.entity.jyukirendotorokushalistbatchentity.JyukiRendoTorokushaListBatchEntity;
import jp.co.ndensan.reams.db.dba.entity.jyukirendotorokushalistbatchentity.JyukiRendoTorokushaListTyouHyouListEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票データ作成クラス
 */
public class JyukiRendoTorokushaListBatch {

    private static final RString 印刷時刻 = new RString("   時  分  秒");
    private static final int ページ数 = 0;

    /**
     * 帳票データ作成
     *
     * @param entity 住基連動登録者リストEntity
     * @return JyukiRendoTorokushaListTyouHyouListEntity
     */
    public List<JukiRendoTorokuListItem> getIdoCheckChohyoData(
            JyukiRendoTorokushaListBatchEntity entity) {
        List<JukiRendoTorokuListItem> list = new ArrayList();
        RDate nowDate = RDate.getNowDate();
        RString 印刷日時 = nowDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

        for (JyukiRendoJouhouEntity jyukiRendoJouhouEntity : entity.get住基連動情報()) {
            JyukiRendoTorokushaListTyouHyouListEntity jyukiRendoTorokushaListTyouHyouListEntity
                    = new JyukiRendoTorokushaListTyouHyouListEntity();
            jyukiRendoTorokushaListTyouHyouListEntity.set印刷日時(new RString(印刷日時.toString() + 印刷時刻.toString()));
            jyukiRendoTorokushaListTyouHyouListEntity.setページ数(new RString(String.valueOf(ページ数 + 1)));
            jyukiRendoTorokushaListTyouHyouListEntity.set帳票タイトル(new RString("住基連動登録者リスト"));
            jyukiRendoTorokushaListTyouHyouListEntity.set市町村コード(new RString(entity.get市町村コード().toString()));
            jyukiRendoTorokushaListTyouHyouListEntity.set市町村名(entity.get市町村名());
            jyukiRendoTorokushaListTyouHyouListEntity.set並び順１(entity.get並び順_1());
            jyukiRendoTorokushaListTyouHyouListEntity.set並び順２(entity.get並び順_2());
            jyukiRendoTorokushaListTyouHyouListEntity.set並び順３(entity.get並び順_3());
            jyukiRendoTorokushaListTyouHyouListEntity.set並び順４(entity.get並び順_4());
            jyukiRendoTorokushaListTyouHyouListEntity.set並び順５(entity.get並び順_5());
            if (jyukiRendoJouhouEntity.get識別コード() == null) {
                set帳票データ作成用Entityの部分項目(jyukiRendoTorokushaListTyouHyouListEntity, jyukiRendoJouhouEntity);
                jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_被保険者氏名(
                        new RString("該当データがありません"));
            } else {
                set帳票データ作成用Entityの部分項目(jyukiRendoTorokushaListTyouHyouListEntity, jyukiRendoJouhouEntity);
                if (jyukiRendoJouhouEntity.get被保険者氏名() != null) {
                    jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_被保険者氏名(
                            new RString(jyukiRendoJouhouEntity.get被保険者氏名().toString()));
                }
            }
            JukiRendoTorokuListItem jukiRendoTorokuListItem = new JukiRendoTorokuListItem(
                    jyukiRendoTorokushaListTyouHyouListEntity.get印刷日時(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get帳票タイトル(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get市町村コード(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get市町村名(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get並び順１(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get並び順２(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get並び順３(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get並び順４(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get並び順５(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get改頁１(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get改頁２(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get改頁３(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get改頁４(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get改頁５(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get開始タイトル(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get終了タイトル(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get区分タイトル(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get異動情報タイトル1(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get異動情報タイトル2(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get異動情報タイトル3(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get開始年月日タイトル(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get終了年月日タイトル(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get異動情報タイトル4(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get異動情報タイトル5(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get異動情報タイトル6(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_世帯コード(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_被保険者カナ氏名(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_事由(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_異動年月日(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_届出年月日(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_開始年月日(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_事由_2(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_異動年月日_2(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_届出年月日_2(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_終了年月日(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_区分(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_異動情報1(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_異動情報2(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト上_異動情報3(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト_被保険者番号(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_識別コード(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_被保険者氏名(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_事由(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_異動年月日(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_届出年月日(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_開始年月日(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_事由_2(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_異動年月日_2(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_届出年月日_2(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_終了年月日(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_区分(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_異動情報4(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_異動情報5(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getリスト下_異動情報6(),
                    jyukiRendoTorokushaListTyouHyouListEntity.getページ数(),
                    jyukiRendoTorokushaListTyouHyouListEntity.get対象情報タイトル());
            list.add(jukiRendoTorokuListItem);
        }
        return list;
    }

    /**
     * 帳票データ作成用Entityの部分項目を設定します
     *
     * @param jyukiRendoTorokushaListTyouHyouListEntity 住基連動登録者リスト帳票用データリストEntity
     * @param jyukiRendoJouhouEntity 住基連動情報Entity
     */
    private void set帳票データ作成用Entityの部分項目(
            JyukiRendoTorokushaListTyouHyouListEntity jyukiRendoTorokushaListTyouHyouListEntity,
            JyukiRendoJouhouEntity jyukiRendoJouhouEntity) {
        jyukiRendoTorokushaListTyouHyouListEntity.set対象情報タイトル(jyukiRendoJouhouEntity.get対象情報タイトル());
        jyukiRendoTorokushaListTyouHyouListEntity.set改頁１(jyukiRendoJouhouEntity.get改頁１());
        jyukiRendoTorokushaListTyouHyouListEntity.set改頁２(jyukiRendoJouhouEntity.get改頁２());
        jyukiRendoTorokushaListTyouHyouListEntity.set改頁３(jyukiRendoJouhouEntity.get改頁３());
        jyukiRendoTorokushaListTyouHyouListEntity.set改頁４(jyukiRendoJouhouEntity.get改頁４());
        jyukiRendoTorokushaListTyouHyouListEntity.set改頁５(jyukiRendoJouhouEntity.get改頁５());
        jyukiRendoTorokushaListTyouHyouListEntity.set開始タイトル(jyukiRendoJouhouEntity.get開始タイトル());
        jyukiRendoTorokushaListTyouHyouListEntity.set終了タイトル(jyukiRendoJouhouEntity.get終了タイトル());
        jyukiRendoTorokushaListTyouHyouListEntity.set区分タイトル(jyukiRendoJouhouEntity.get区分タイトル());
        jyukiRendoTorokushaListTyouHyouListEntity.set異動情報タイトル1(jyukiRendoJouhouEntity.get異動情報タイトル1());
        jyukiRendoTorokushaListTyouHyouListEntity.set異動情報タイトル2(jyukiRendoJouhouEntity.get異動情報タイトル2());
        jyukiRendoTorokushaListTyouHyouListEntity.set異動情報タイトル3(jyukiRendoJouhouEntity.get異動情報タイトル3());
        jyukiRendoTorokushaListTyouHyouListEntity.set開始年月日タイトル(jyukiRendoJouhouEntity.get開始年月日タイトル());
        jyukiRendoTorokushaListTyouHyouListEntity.set終了年月日タイトル(jyukiRendoJouhouEntity.get終了年月日タイトル());
        jyukiRendoTorokushaListTyouHyouListEntity.set異動情報タイトル4(jyukiRendoJouhouEntity.get異動情報タイトル4());
        jyukiRendoTorokushaListTyouHyouListEntity.set異動情報タイトル5(jyukiRendoJouhouEntity.get異動情報タイトル5());
        jyukiRendoTorokushaListTyouHyouListEntity.set異動情報タイトル6(jyukiRendoJouhouEntity.get異動情報タイトル6());
        if (jyukiRendoJouhouEntity.get世帯コード() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_世帯コード(new RString(jyukiRendoJouhouEntity
                    .get世帯コード().toString()));
        }
        if (jyukiRendoJouhouEntity.get被保険者カナ氏名() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_被保険者カナ氏名(
                    new RString(jyukiRendoJouhouEntity.get被保険者カナ氏名().toString()));
        }
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_事由(jyukiRendoJouhouEntity.get取得情報_前_事由());
        if (jyukiRendoJouhouEntity.get取得情報_前_異動年月日() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_異動年月日(
                    jyukiRendoJouhouEntity.get取得情報_前_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get取得情報_前_届出年月日() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_届出年月日(
                    jyukiRendoJouhouEntity.get取得情報_前_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get開始年月日データ_前() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_開始年月日(
                    jyukiRendoJouhouEntity.get開始年月日データ_前()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_事由_2(jyukiRendoJouhouEntity.get喪失情報_前_事由());
        if (jyukiRendoJouhouEntity.get喪失情報_前_異動年月日() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_異動年月日_2(
                    jyukiRendoJouhouEntity.get喪失情報_前_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get喪失情報_前_届出年月日() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_届出年月日_2(
                    jyukiRendoJouhouEntity.get喪失情報_前_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get終了年月日データ_前() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_終了年月日(
                    jyukiRendoJouhouEntity.get終了年月日データ_前()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_区分(jyukiRendoJouhouEntity.get区分_前_資格());
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_異動情報1(jyukiRendoJouhouEntity.get異動情報データ1());
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_異動情報2(jyukiRendoJouhouEntity.get異動情報データ2());
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト上_異動情報3(jyukiRendoJouhouEntity.get異動情報データ3());
        if (jyukiRendoJouhouEntity.get被保険者番号() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト_被保険者番号(new RString(jyukiRendoJouhouEntity
                    .get被保険者番号().toString()));
        }
        if (jyukiRendoJouhouEntity.get識別コード() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_識別コード(new RString(jyukiRendoJouhouEntity
                    .get識別コード().toString()));
        }
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_事由(jyukiRendoJouhouEntity.get取得情報_後_事由());
        if (jyukiRendoJouhouEntity.get取得情報_後_異動年月日() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_異動年月日(
                    jyukiRendoJouhouEntity.get取得情報_後_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get取得情報_後_届出年月日() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_届出年月日(
                    jyukiRendoJouhouEntity.get取得情報_後_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get開始年月日データ_後() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_開始年月日(
                    jyukiRendoJouhouEntity.get開始年月日データ_後()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_事由_2(jyukiRendoJouhouEntity.get喪失情報_後_事由());
        if (jyukiRendoJouhouEntity.get喪失情報_後_異動年月日() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_異動年月日_2(
                    jyukiRendoJouhouEntity.get喪失情報_後_異動年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get喪失情報_後_届出年月日() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_届出年月日_2(
                    jyukiRendoJouhouEntity.get喪失情報_後_届出年月日()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        if (jyukiRendoJouhouEntity.get終了年月日データ_後() != null) {
            jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_終了年月日(
                    jyukiRendoJouhouEntity.get終了年月日データ_後()
                    .wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_区分(jyukiRendoJouhouEntity.get区分_後_資格());
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_異動情報4(jyukiRendoJouhouEntity.get異動情報データ4());
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_異動情報5(jyukiRendoJouhouEntity.get異動情報データ5());
        jyukiRendoTorokushaListTyouHyouListEntity.setリスト下_異動情報6(jyukiRendoJouhouEntity.get異動情報データ6());
    }

}
