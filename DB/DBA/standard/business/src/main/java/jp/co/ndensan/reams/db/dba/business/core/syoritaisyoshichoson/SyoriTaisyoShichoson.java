/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.syoritaisyoshichoson;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba050010.JuminkirokuIdojohoTorokuKoikiProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoChushutsuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JutogaiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民異動連携情報登録【広域保険者用】のBusinessのパラメータ。
 *
 * @reamsid_L DBA-1390-010 wanghuafeng
 */
public class SyoriTaisyoShichoson {

    /**
     * 宛名識別対象異動分取得します。
     *
     * @param 抽出開始日時 RDateTime
     * @param processParameter JuminkirokuIdojohoTorokuKoikiProcessParameter
     * @return keyBuilder
     */
    public ShikibetsuTaishoIdoSearchKeyBuilder 宛名識別対象異動分取得PSM(RDateTime 抽出開始日時,
            JuminkirokuIdojohoTorokuKoikiProcessParameter processParameter) {
        ShikibetsuTaishoIdoSearchKeyBuilder keyBuilder = new ShikibetsuTaishoIdoSearchKeyBuilder(
                ShikibetsuTaishoIdoChushutsuKubun.異動処理日時と異動事由で異動前後を抽出,
                抽出開始日時, processParameter.getSyorinichiji().getRDateTime());
        List<JukiIdoJiyu> juminShubetsu = new ArrayList<>();
        juminShubetsu.add(JukiIdoJiyu.転入);
        juminShubetsu.add(JukiIdoJiyu.第30条の46届出);
        juminShubetsu.add(JukiIdoJiyu.特例による転入);
        juminShubetsu.add(JukiIdoJiyu.附則第5条届出);
        juminShubetsu.add(JukiIdoJiyu.第30条の47届出);
        juminShubetsu.add(JukiIdoJiyu.転出);
        juminShubetsu.add(JukiIdoJiyu.特例による転出);
        juminShubetsu.add(JukiIdoJiyu.死亡);
        juminShubetsu.add(JukiIdoJiyu.特殊修正);
        juminShubetsu.add(JukiIdoJiyu.履歴修正);
        juminShubetsu.add(JukiIdoJiyu.異動取消);
        juminShubetsu.add(JukiIdoJiyu.転居);
        juminShubetsu.add(JukiIdoJiyu.職権修正);
        juminShubetsu.add(JukiIdoJiyu.戸籍照合修正);
        juminShubetsu.add(JukiIdoJiyu.転入通知受理);
        juminShubetsu.add(JukiIdoJiyu.婚姻);
        juminShubetsu.add(JukiIdoJiyu.離婚);
        juminShubetsu.add(JukiIdoJiyu.養子縁組);
        juminShubetsu.add(JukiIdoJiyu.養子離縁);
        juminShubetsu.add(JukiIdoJiyu.転籍);
        juminShubetsu.add(JukiIdoJiyu.分籍);
        juminShubetsu.add(JukiIdoJiyu.入籍);
        juminShubetsu.add(JukiIdoJiyu.認知);
        juminShubetsu.add(JukiIdoJiyu.戸籍その他);
        juminShubetsu.add(JukiIdoJiyu.通称の記載);
        juminShubetsu.add(JukiIdoJiyu.通称の削除);
        juminShubetsu.add(JukiIdoJiyu.戸籍届出以外による婚姻);
        List<JutogaiIdoJiyu> jutogaiIdoJiyu = new ArrayList<>();
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.住基異動者追加);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.住民種別変更);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.修正);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.優先氏名変更);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.削除);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.削除回復);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.履歴修正);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.履歴削除);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.新規追加);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.物理削除);
        jutogaiIdoJiyu.add(JutogaiIdoJiyu.誤謬修正);
        // TODO  現全国地方公共団体コードと住登外異動事由使用有無と住基異動事由使用有無があります。QA:1258
        keyBuilder.set個人のみ取得区分(true);
        keyBuilder.set住基異動事由コードList(juminShubetsu);
        keyBuilder.set住登外異動事由コードList(jutogaiIdoJiyu);
        return keyBuilder;
    }

    /**
     * データ更新します。
     *
     * @param processParameter JuminkirokuIdojohoTorokuKoikiProcessParameter
     * @param entity DbT7022ShoriDateKanriEntity
     */
    public void データ更新(JuminkirokuIdojohoTorokuKoikiProcessParameter processParameter, DbT7022ShoriDateKanriEntity entity) {
        entity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
        entity.setShoriName(ShoriName.広域住基連動.get名称());
        entity.setKijunTimestamp(processParameter.getSyorinichiji());
        entity.setTaishoShuryoTimestamp(processParameter.getSyorinichiji());
    }

    /**
     * データ登録します。
     *
     * @param processParameter JuminkirokuIdojohoTorokuKoikiProcessParameter
     * @param entity DbT7022ShoriDateKanriEntity
     */
    public void データ登録(JuminkirokuIdojohoTorokuKoikiProcessParameter processParameter, DbT7022ShoriDateKanriEntity entity) {
        entity.setSubGyomuCode(SubGyomuCode.DBA介護資格);
        entity.setShoriName(ShoriName.広域住基連動.get名称());
        entity.setShoriEdaban(new RString("01"));
        entity.setNendoNaiRenban(new RString("01"));
        entity.setNendo(new FlexibleYear("0000"));
        entity.setKijunYMD(FlexibleDate.EMPTY);
        entity.setKijunTimestamp(processParameter.getSyorinichiji());
        entity.setTaishoKaishiYMD(FlexibleDate.EMPTY);
        entity.setTaishoShuryoYMD(FlexibleDate.EMPTY);
//            TODO 1826未回答ので、実装しない
        entity.setTaishoKaishiTimestamp(new YMDHMS(DbBusinessConfig.get(ConfigNameDBU.介護保険法情報_介護保険施行日,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
        entity.setTaishoShuryoTimestamp(processParameter.getSyorinichiji());
    }
}
