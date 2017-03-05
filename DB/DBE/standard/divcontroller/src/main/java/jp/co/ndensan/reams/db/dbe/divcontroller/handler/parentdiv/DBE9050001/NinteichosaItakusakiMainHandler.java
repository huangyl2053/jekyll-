/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9050001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.SonotaKikanJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.ShichosonMeishoBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.ChosaitakusakiJohoInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.NinteichosaItakusakiMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001.dgSonotaKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotakikanmaster.SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiiryokikanmaster.KoseiShujiiIryoKikanMasterFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKikanKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ua.uax.business.core.koza.YokinShubetsuPattern;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanManager;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * その他機関マスタ画面のハンドラークラスです。
 *
 * @reamsid_L DBE-1360-010 suguangjun
 */
public class NinteichosaItakusakiMainHandler {

    private static final RString 表示値_有効 = new RString("有効");
    private static final RString 表示値_無効 = new RString("無効");
    private static final RString CODE_有効 = new RString("yuko");
    private static final RString CODE_無効 = new RString("muko");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString ハイフン = new RString("-");
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final RString SELECTKEY_空白 = RString.EMPTY;
    private static final RString 調査委託区分_3 = new RString("3");
    private static final RString 調査委託区分_4 = new RString("4");
    private static final RString 調査委託区分_5 = new RString("5");
    private static final RString 調査委託区分_6 = new RString("6");
    private static final RString 調査委託区分_9 = new RString("9");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString 保険者_市町村等 = new RString("保険者（市町村等）");
    private static final RString 指定市町村事務受託法人 = new RString("指定市町村事務受託法人");
    private static final RString 指定居宅介護支援事業者 = new RString("指定居宅介護支援事業者");
    private static final RString 介護保険施設 = new RString("介護保険施設");
    private static final RString 介護支援専門員 = new RString("介護支援専門員");
    private static final RString 他市町村 = new RString("他市町村");
    private static final RString その他 = new RString("その他");
    private static final RString 非調査機関 = new RString("非調査機関");
    private static final RString 調査機関 = new RString("調査機関");
    private static final RString 前方一致KEY = new RString("0");
    private static final RString 預金種別 = new RString("預金種別");
    private static final RString 預金種目 = new RString("預金種目");

    private final NinteichosaItakusakiMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div その他機関マスタDiv
     */
    public NinteichosaItakusakiMainHandler(NinteichosaItakusakiMainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void load() {
        div.getCcdhokensha().loadHokenshaList(GyomuBunrui.介護認定);
        div.getChosaitakusakiJohoInput().getCcdChiku().load(DBECodeShubetsu.調査地区コード.getコード());
        div.getRadSearchHaisiFlag().setSelectedKey(KEY0);
        div.getTxtSaidaiHyojiKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getDdlitakukubun().setDataSource(setItakukubun());
        div.getDdlitakukubun().setSelectedKey(SELECTKEY_空白);
        div.getDdlkikankubun().setDataSource(setKikankubun());
        div.getDdlkikankubun().setSelectedKey(SELECTKEY_空白);
    }

    /**
     * 調査委託区分を設定します。
     *
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> setItakukubun() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(SELECTKEY_空白, RString.EMPTY));
        for (ChosaItakuKubunCode kubunCode : ChosaItakuKubunCode.values()) {
            KeyValueDataSource kukubunDataSource = new KeyValueDataSource(kubunCode.getコード(),
                    kubunCode.get名称());
            dataSource.add(kukubunDataSource);
        }
        return dataSource;
    }

    /**
     * 機関の区分を設定します。
     *
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> setKikankubun() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(SELECTKEY_空白, RString.EMPTY));
        for (ChosaKikanKubun kubun : ChosaKikanKubun.values()) {
            KeyValueDataSource kukubunDataSource = new KeyValueDataSource(kubun.getコード(),
                    kubun.get名称());
            dataSource.add(kukubunDataSource);
        }
        return dataSource;
    }

    /**
     * 検索条件入力項目をクリアします。
     */
    public void clearKensakuJoken() {
        div.getTxtSearchSonotaKikanCodeFrom().clearValue();
        div.getTxtSearchSonotaKikanCodeTo().clearValue();
        div.getTxtSearchSonotaKikanMeisho().clearValue();
        div.getTxtSearchSonotaKikanKanaMeisho().clearValue();
        div.getDdlitakukubun().setSelectedKey(SELECTKEY_空白);
        div.getDdlkikankubun().setSelectedKey(SELECTKEY_空白);
        div.getTxtSaidaiHyojiKensu().clearValue();
        div.getCcdhokensha().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTxtSaidaiHyojiKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getDdlKikanMeisho().setSelectedKey(前方一致KEY);
        div.getDdlKikanKanaMeisho().setSelectedKey(前方一致KEY);
        div.getRadSearchHaisiFlag().setSelectedKey(KEY0);
    }

    /**
     * その他機関一覧へのデータを設定します。
     *
     * @param sonotaKikanJohoList その他機関一覧List
     */
    public void setSonotaKikanichiran(List<SonotaKikanJohoEntity> sonotaKikanJohoList) {
        List<KinyuKikan> kinyuKikans = KinyuKikanManager.createInstance().getValidKinyuKikansOn(FlexibleDate.getNowDate());
        List<dgSonotaKikanIchiran_Row> dataGridList = new ArrayList<>();
        for (SonotaKikanJohoEntity sonotaKikanJohoEntity : sonotaKikanJohoList) {
            dataGridList.add(createDgSonotaKikanichiranRow(
                    RString.EMPTY,
                    sonotaKikanJohoEntity.getHokenshaName(),
                    sonotaKikanJohoEntity.getShoKisaiHokenshaNo(),
                    sonotaKikanJohoEntity.getSonotaKikanCode(),
                    sonotaKikanJohoEntity.getKikanMeisho(),
                    sonotaKikanJohoEntity.getKikanMeishoKana(),
                    sonotaKikanJohoEntity.getYubinNo(),
                    sonotaKikanJohoEntity.getJusho(),
                    sonotaKikanJohoEntity.getJushoKana(),
                    sonotaKikanJohoEntity.getTelNo(),
                    sonotaKikanJohoEntity.getChosaItakuKubun(),
                    sonotaKikanJohoEntity.getWaritsukeTeiin(),
                    sonotaKikanJohoEntity.getWaritsukeChiku(),
                    sonotaKikanJohoEntity.getKikanKubun(),
                    sonotaKikanJohoEntity.isYuko(),
                    sonotaKikanJohoEntity.getKinyuKikanCode(),
                    sonotaKikanJohoEntity.getKinyuKikanShitenCode(),
                    sonotaKikanJohoEntity.getYokinShubetsu(),
                    sonotaKikanJohoEntity.getKozaNo(),
                    sonotaKikanJohoEntity.getKozaMeigininKana(),
                    sonotaKikanJohoEntity.getKozaMeiginin(),
                    kinyuKikans
            ));
        }
        if (dataGridList.isEmpty()) {
            div.getSonotaKikanichiran().getBtnOutputCsv().setVisible(false);
        } else {
            div.getSonotaKikanichiran().getBtnOutputCsv().setVisible(true);
        }

        div.getSonotaKikanichiran().getDgSonotaKikanIchiran().setDataSource(dataGridList);
    }

    private dgSonotaKikanIchiran_Row createDgSonotaKikanichiranRow(
            RString jotai,
            RString hokensha,
            ShoKisaiHokenshaNo hokenshaNo,
            RString sonotaKikanCode,
            RString kikanMeisho,
            RString kikanKana,
            YubinNo yubinNo,
            RString jusho,
            RString jushoKana,
            TelNo telNo,
            RString chosaItakuKubun,
            int waritsukeTeiin,
            ChikuCode chiku,
            RString kikanKubun,
            boolean jokyoFlag,
            KinyuKikanCode kinyuKikanCode,
            KinyuKikanShitenCode kinyuKikanShitenCode,
            RString yokinShubetsu,
            RString kozaNo,
            AtenaKanaMeisho kozaMeigininKana,
            AtenaMeisho kozaMeiginin,
            List<KinyuKikan> 金融機関情報
    ) {
        dgSonotaKikanIchiran_Row row = new dgSonotaKikanIchiran_Row();
        row.setJotai(nullToEmpty(jotai));
        row.setHokensha(nullToEmpty(hokensha));
        if (hokenshaNo != null) {
            row.setHokenshaCode(hokenshaNo.value());
        }
        row.setSonotaKikanCode(sonotaKikanCode);
        row.setKikanMeisho(nullToEmpty(kikanMeisho));
        row.setKikanKana(nullToEmpty(kikanKana));
        if (yubinNo != null) {
            row.setYubinNo(editYubinNoToIchiran(yubinNo.value()));
        }
        row.setJusho(nullToEmpty(jusho));
        row.setJushoKana(nullToEmpty(jushoKana));
        if (telNo != null) {
            row.setTelNo(telNo.value());
        }
        if (chosaItakuKubun != null && !RString.isNullOrEmpty(chosaItakuKubun.trim())) {
            row.setChosaItakuKubun(nullToEmpty(ChosaItakuKubunCode.toValue(chosaItakuKubun).get名称()));
        }
        TextBoxNum num = new TextBoxNum();
        num.setValue(new Decimal(waritsukeTeiin));
        row.setWaritsukeTeiin(num);
        if (chiku != null) {
            row.setChiku(chiku.value());
        }
        if (kikanKubun != null && !RString.isNullOrEmpty(kikanKubun.trim())) {
            row.setKikanKubun(nullToEmpty(ChosaKikanKubun.toValue(kikanKubun).get名称()));
        }
        if (jokyoFlag) {
            row.setJokyoFlag(表示値_有効);
        } else {
            row.setJokyoFlag(表示値_無効);
        }
        //口座情報
        row.setKinyuKikanCode(kinyuKikanCode == null ? RString.EMPTY : kinyuKikanCode.value());
        row.setKinyuKikanShitenCode(kinyuKikanShitenCode == null ? RString.EMPTY : kinyuKikanShitenCode.value());
        row.setYokinShu(nullToEmpty(yokinShubetsu));
        row.setYokinShuMei(kinyuKikanCode == null ? RString.EMPTY : get預金種名(金融機関情報, kinyuKikanCode.getColumnValue(), yokinShubetsu));
        row.setKozaNo(nullToEmpty(kozaNo));
        row.setKozaMeigininKana(kozaMeigininKana == null ? RString.EMPTY : kozaMeigininKana.value());
        row.setKozaMeiginin(kozaMeiginin == null ? RString.EMPTY : kozaMeiginin.value());
        row.setKinyuKikanMeisho(getKinyuKikan(金融機関情報, row));
        row.setShitenMeisho(getKinyuShiten(金融機関情報, row));
        return row;
    }

    /**
     * その他機関詳細情報を設定します。
     *
     * @param row その他機関詳細情報
     */
    public void setChosaitakusakiJohoInput(dgSonotaKikanIchiran_Row row) {
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().intialize(new HokenjaNo(row.getHokenshaCode()));
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setHokenjaName(row.getHokensha());
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().setValue(row.getSonotaKikanCode());
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().setValue(row.getKikanMeisho());
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().setValue(row.getKikanKana());
        if (row.getYubinNo() != null) {
            if (row.getYubinNo().length() == INDEX_4 && row.getYubinNo().contains("-")) {
                div.getChosaitakusakiJohoInput().getTxtYubinNo().setValue(new YubinNo(row.getYubinNo().remove(INDEX_3)));
            } else {
                div.getChosaitakusakiJohoInput().getTxtYubinNo().setValue(new YubinNo(row.getYubinNo()));
            }
        }
        if (row.getJusho() != null) {
            div.getChosaitakusakiJohoInput().getTxtJusho().setDomain(new AtenaJusho(row.getJusho()));
        }
        if (row.getJushoKana() != null) {
            div.getChosaitakusakiJohoInput().getTxtJushoKana().setDomain(new AtenaJusho(row.getJushoKana()));
        }
        if (row.getTelNo() != null) {
            div.getChosaitakusakiJohoInput().getTxtTelNo().setDomain(new TelNo(row.getTelNo()));
        }
        if (row.getWaritsukeTeiin().getValue() != null) {
            div.getChosaitakusakiJohoInput().getTxtteiin().setValue(row.getWaritsukeTeiin().getValue());
        }
        div.getChosaitakusakiJohoInput().getCcdChiku().applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(),
                new Code(row.getChiku()));
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setDataSource(setItakukubun());
        if (!RString.isNullOrEmpty(row.getChosaItakuKubun())) {
            div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setSelectedKey(get調査委託区分(row));
        }
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setDataSource(setKikankubun());
        if (!RString.isNullOrEmpty(row.getKikanKubun())) {
            div.getChosaitakusakiJohoInput().getDdlKikankubun().setSelectedKey(get機関の区分(row));
        }
        if (表示値_有効.equals(row.getJokyoFlag())) {
            div.getChosaitakusakiJohoInput().getRadHaishiFlag().setSelectedKey(CODE_有効);
        } else {
            div.getChosaitakusakiJohoInput().getRadHaishiFlag().setSelectedKey(CODE_無効);
        }
        //口座情報
        div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().search(
                new KinyuKikanCode(row.getKinyuKikanCode()), new KinyuKikanShitenCode(row.getKinyuKikanShitenCode()), FlexibleDate.getNowDate());
        setKozaJoho();
        if (!RString.isNullOrEmpty(row.getYokinShu())) {
            div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShu().setSelectedKey(row.getYokinShu());
        }
        KinyuKikanManager kinyuKikanManager = KinyuKikanManager.createInstance();
        List<KinyuKikan> 金融機関情報 = new ArrayList<>();
        金融機関情報 = kinyuKikanManager.getValidKinyuKikansOn(FlexibleDate.getNowDate());
        if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput() != null) {
            if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().isゆうちょ銀行()) {
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().setValue(row.getKinyuKikanShitenCode());
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().setValue(getKinyuShiten(金融機関情報, row));
            }
        }
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().setValue(row.getKozaNo());
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().setValue(row.getKozaMeigininKana());
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKanjiMeiginin().setValue(row.getKozaMeiginin());
    }

    private RString get調査委託区分(dgSonotaKikanIchiran_Row row) {
        RString 調査委託区分 = RString.EMPTY;
        if (保険者_市町村等.equals(row.getChosaItakuKubun())) {
            調査委託区分 = new RString("1");
        } else if (指定市町村事務受託法人.equals(row.getChosaItakuKubun())) {
            調査委託区分 = new RString("2");
        } else if (指定居宅介護支援事業者.equals(row.getChosaItakuKubun())) {
            調査委託区分 = 調査委託区分_3;
        } else if (介護保険施設.equals(row.getChosaItakuKubun())) {
            調査委託区分 = 調査委託区分_4;
        } else if (介護支援専門員.equals(row.getChosaItakuKubun())) {
            調査委託区分 = 調査委託区分_5;
        } else if (他市町村.equals(row.getChosaItakuKubun())) {
            調査委託区分 = 調査委託区分_6;
        } else if (その他.equals(row.getChosaItakuKubun())) {
            調査委託区分 = 調査委託区分_9;
        }
        return 調査委託区分;
    }

    private RString get機関の区分(dgSonotaKikanIchiran_Row row) {
        RString 機関の区分 = RString.EMPTY;
        if (非調査機関.equals(row.getKikanKubun())) {
            機関の区分 = new RString("0");
        } else if (調査機関.equals(row.getKikanKubun())) {
            機関の区分 = new RString("1");
        }
        return 機関の区分;
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * その他機関情報を設定します。
     *
     * @param eventJotai 状態
     */
    public void setSonotaKikanichiran(RString eventJotai) {
        dgSonotaKikanIchiran_Row row = new dgSonotaKikanIchiran_Row();
        if (!状態_追加.equals(eventJotai)) {
            row = ViewStateHolder.get(ViewStateKeys.その他機関マスタ選択行, dgSonotaKikanIchiran_Row.class);
        }
        row.setHokensha(nullToEmpty(div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().getHokenjaName()));
        row.setHokenshaCode(nullToEmpty(div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().getHokenjaNo()));
        row.setSonotaKikanCode(div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().getValue());
        row.setKikanMeisho(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().getValue()));
        row.setKikanKana(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().getValue()));
        row.setYubinNo(editYubinNoToIchiran(div.getChosaitakusakiJohoInput().getTxtYubinNo().getValue().value()));
        row.setJusho(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtJusho().getDomain().value()));
        row.setJushoKana(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtJushoKana().getDomain().value()));
        row.setTelNo(nullToEmpty(div.getChosaitakusakiJohoInput().getTxtTelNo().getDomain().value()));
        row.setChosaItakuKubun(nullToEmpty(div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getSelectedValue()));
        TextBoxNum num = new TextBoxNum();
        if (div.getChosaitakusakiJohoInput().getTxtteiin().getValue() != null) {
            num.setValue(new Decimal(div.getChosaitakusakiJohoInput().getTxtteiin().getValue().toString()));
            row.setWaritsukeTeiin(num);
        }
        if (div.getChosaitakusakiJohoInput().getCcdChiku() != null) {
            row.setChiku(div.getChosaitakusakiJohoInput().getCcdChiku().getCode().value());
        }
        row.setKikanKubun(nullToEmpty(div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedValue()));
        if (CODE_有効.equals(div.getChosaitakusakiJohoInput().getRadHaishiFlag().getSelectedKey())) {
            row.setJokyoFlag(表示値_有効);
        } else {
            row.setJokyoFlag(表示値_無効);
        }
        //口座情報
        KinyuKikanManager kinyuKikanManager = KinyuKikanManager.createInstance();
        List<KinyuKikan> 金融機関情報 = new ArrayList<>();
        金融機関情報 = kinyuKikanManager.getValidKinyuKikansOn(FlexibleDate.getNowDate());
        RString kinyuKikanCode = nullToEmpty(div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode().value());
        RString yokinShu = nullToEmpty(div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShu().getSelectedKey());
        row.setKinyuKikanCode(kinyuKikanCode);
        row.setYokinShu(yokinShu);
        row.setYokinShuMei(kinyuKikanCode == null ? RString.EMPTY : get預金種名(金融機関情報, kinyuKikanCode, yokinShu));
        row.setKozaNo(nullToEmpty(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().getValue()));
        row.setKozaMeigininKana(nullToEmpty(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().getValue()));
        row.setKozaMeiginin(nullToEmpty(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKanjiMeiginin().getValue()));
        if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput() != null) {
            if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関() != null) {
                row.setKinyuKikanMeisho(nullToEmpty(div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関().get金融機関名称()));
            } else {
                row.setKinyuKikanMeisho(RString.EMPTY);
            }
            if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().isゆうちょ銀行()) {
                row.setKinyuKikanShitenCode(nullToEmpty(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().getValue()));
                row.setShitenMeisho(nullToEmpty(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().getValue()));
            } else {
                row.setKinyuKikanShitenCode(nullToEmpty(div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanShitenCode().value()));
                if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関() != null) {
                    row.setShitenMeisho(nullToEmpty(div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関支店().get支店名称()));
                } else {
                    row.setShitenMeisho(RString.EMPTY);
                }
            }
        } else {
            row.setKinyuKikanMeisho(RString.EMPTY);
            row.setKinyuKikanShitenCode(RString.EMPTY);
            row.setShitenMeisho(RString.EMPTY);
        }
        int index = row.getId();
        if (状態_追加.equals(eventJotai)) {
            row.setJotai(eventJotai);
            div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource().add(row);
        } else if (状態_削除.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource().remove(index);
        } else if (状態_修正.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource().set(index, row);
        } else {
            row.setJotai(eventJotai);
            div.getSonotaKikanichiran().getDgSonotaKikanIchiran().getDataSource().set(index, row);
        }
        ViewStateHolder.put(ViewStateKeys.その他機関マスタ選択行, row);
    }

    private RString editYubinNoToIchiran(RString yubinNo) {
        RStringBuilder yubinNoSb = new RStringBuilder();
        if (INDEX_3 <= yubinNo.length()) {
            yubinNoSb.append(yubinNo.substring(0, INDEX_3));
            yubinNoSb.append(ハイフン);
            yubinNoSb.append(yubinNo.substring(INDEX_3));
        } else {
            yubinNoSb.append(yubinNo);
        }
        return yubinNoSb.toRString();
    }

    /**
     * その他機関情報を設定します。
     *
     * @param sonotaKikanJoho その他機関情報
     * @return sonotaKikanJoho その他機関情報
     */
    public SonotaKikanJoho editSonotaKikanJoho(SonotaKikanJoho sonotaKikanJoho) {
        Decimal chosaKanoNinzu = div.getChosaitakusakiJohoInput().getTxtteiin().getValue();
        int 割付定員 = 0;
        if (chosaKanoNinzu != null) {
            割付定員 = chosaKanoNinzu.intValue();
        }
        KinyuKikanCode 金融機関コード = KinyuKikanCode.EMPTY;
        KinyuKikanShitenCode 金融機関支店コード = new KinyuKikanShitenCode(new RString(""));
        RString 預金種別コード = new RString("");
        if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput() != null
                && div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode() != null) {
            金融機関コード = div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode();
        }
        if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput() != null) {
            if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().isゆうちょ銀行()) {
                金融機関支店コード = new KinyuKikanShitenCode(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().getValue());
            } else {
                金融機関支店コード = div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanShitenCode();
            }
            預金種別コード = div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShu().getSelectedKey();
        }
        return sonotaKikanJoho.createBuilderForEdit()
                .set機関名称(div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().getValue())
                .set機関名称カナ(div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().getValue())
                .set郵便番号(div.getChosaitakusakiJohoInput().getTxtYubinNo().getValue())
                .set住所(div.getChosaitakusakiJohoInput().getTxtJusho().getDomain().value())
                .set住所カナ(div.getChosaitakusakiJohoInput().getTxtJushoKana().getDomain().value())
                .set電話番号(div.getChosaitakusakiJohoInput().getTxtTelNo().getDomain())
                .set調査委託区分(div.getChosaitakusakiJohoInput().getDdlItakusakikubun().getSelectedKey())
                .set割付定員(割付定員)
                .set割付地区(new ChikuCode(div.getChosaitakusakiJohoInput().getCcdChiku().getCode().value()))
                .set機関の区分(div.getChosaitakusakiJohoInput().getDdlKikankubun().getSelectedKey())
                .set廃止フラグ(CODE_有効.equals(div.getChosaitakusakiJohoInput().getRadHaishiFlag().getSelectedKey()))
                .set金融機関コード(金融機関コード)
                .set金融機関支店コード(金融機関支店コード)
                .set預金種別(預金種別コード)
                .set口座番号(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().getValue())
                .set口座名義人カナ(new AtenaKanaMeisho(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().getValue()))
                .set漢字名義人(new AtenaMeisho(div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKanjiMeiginin().getValue()))
                .build();
    }

    /**
     * その他機関情報エリアをクリアします。
     */
    public void clearChosaitakusakiJohoInput() {
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().clear();
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().clearValue();
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().clearValue();
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().clearValue();
        div.getChosaitakusakiJohoInput().getTxtYubinNo().clearValue();
        div.getChosaitakusakiJohoInput().getTxtJusho().clearDomain();
        div.getChosaitakusakiJohoInput().getTxtJushoKana().clearDomain();
        div.getChosaitakusakiJohoInput().getTxtTelNo().clearDomain();
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setSelectedIndex(0);
        div.getChosaitakusakiJohoInput().getTxtteiin().clearValue();
        div.getChosaitakusakiJohoInput().getCcdChiku().clearDisplayedValues();
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setSelectedIndex(0);
        div.getChosaitakusakiJohoInput().getRadHaishiFlag().setSelectedKey(CODE_有効);
        div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().clear();
        div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShu().setSelectedIndex(0);
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().clearValue();
        div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKanjiMeiginin().clearValue();
    }

    /**
     * その他機関情報登録エリアが非活性に設定します。
     */
    public void setDisabledTrueToChosaitakusakiJohoInput() {
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtYubinNo().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtJusho().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtJushoKana().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtTelNo().setDisabled(true);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setDisabled(true);
        div.getChosaitakusakiJohoInput().getTxtteiin().setDisabled(true);
        div.getChosaitakusakiJohoInput().getCcdChiku().setDisabled(true);
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setDisabled(true);
        div.getChosaitakusakiJohoInput().getRadHaishiFlag().setDisabled(true);
        div.getChosaitakusakiJohoInput().getKozaJoho().setDisabled(true);
    }

    /**
     * 主治医情報登録エリアが活性に設定します。
     */
    public void setDisabledFalseToShujiiJohoInputMeisai() {
        div.getChosaitakusakiJohoInput().getCcdHokenshaJoho().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanCode().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanname().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtSonotaKikanKananame().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtYubinNo().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtJusho().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtJushoKana().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtTelNo().setDisabled(false);
        div.getChosaitakusakiJohoInput().getDdlItakusakikubun().setDisabled(false);
        div.getChosaitakusakiJohoInput().getTxtteiin().setDisabled(false);
        div.getChosaitakusakiJohoInput().getCcdChiku().setDisabled(false);
        div.getChosaitakusakiJohoInput().getDdlKikankubun().setDisabled(false);
        div.getChosaitakusakiJohoInput().getRadHaishiFlag().setDisabled(false);
        div.getChosaitakusakiJohoInput().getKozaJoho().setDisabled(false);
    }

    /**
     * 主治医情報登録エリアを編集します。
     *
     * @return 編集結果
     */
    public RString getInputDiv() {
        RStringBuilder inputDiv = new RStringBuilder();
        ChosaitakusakiJohoInputDiv shujiiJohoInputDiv = div.getChosaitakusakiJohoInput();
        inputDiv.append(shujiiJohoInputDiv.getTxtSonotaKikanCode().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtSonotaKikanname().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtSonotaKikanKananame().getValue());
        inputDiv.append(shujiiJohoInputDiv.getTxtYubinNo().getValue().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtJusho().getDomain().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtJushoKana().getDomain().value());
        inputDiv.append(shujiiJohoInputDiv.getTxtTelNo().getDomain().value());
        inputDiv.append(shujiiJohoInputDiv.getDdlItakusakikubun().getSelectedKey());
        Decimal tteiin = shujiiJohoInputDiv.getTxtteiin().getValue();
        if (tteiin == null) {
            inputDiv.append(RString.EMPTY);
        } else {
            inputDiv.append(shujiiJohoInputDiv.getTxtteiin().getValue());
        }
        inputDiv.append(shujiiJohoInputDiv.getCcdChiku().getCode().value());
        inputDiv.append(shujiiJohoInputDiv.getDdlKikankubun().getSelectedKey());
        inputDiv.append((shujiiJohoInputDiv.getRadHaishiFlag().getSelectedKey()));
        //口座情報
        inputDiv.append(shujiiJohoInputDiv.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode().value());
        inputDiv.append(shujiiJohoInputDiv.getKozaJoho().getDdlYokinShu().getSelectedKey());
        inputDiv.append(shujiiJohoInputDiv.getKozaJoho().getTxtGinkoKozaNo().getValue());
        inputDiv.append(shujiiJohoInputDiv.getKozaJoho().getTxtKozaMeiginin().getValue());
        inputDiv.append(shujiiJohoInputDiv.getKozaJoho().getTxtKanjiMeiginin().getValue());
        if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput() != null) {
            if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().isゆうちょ銀行()) {
                inputDiv.append(shujiiJohoInputDiv.getKozaJoho().getTxtTenBan().getValue());
            } else {
                inputDiv.append(shujiiJohoInputDiv.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanShitenCode().value());
            }
        }
        return inputDiv.toRString();
    }

    public void setKozaJoho() {
        if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関() == null) {
            return;
        }
        List<YokinShubetsuPattern> yokinShubetsuPatternlist = div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関().get預金種別リスト();
        List<KeyValueDataSource> yokinShubetsuList = new ArrayList<>();
        yokinShubetsuList.add(new KeyValueDataSource(SELECTKEY_空白, RString.EMPTY));
        for (YokinShubetsuPattern yokinShubetsuPattern : yokinShubetsuPatternlist) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
            keyValueDataSource.setKey(yokinShubetsuPattern.get預金種別コード());
            keyValueDataSource.setValue(yokinShubetsuPattern.get預金種別略称());
            yokinShubetsuList.add(keyValueDataSource);
        }
        div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShu().setDataSource(yokinShubetsuList);
        if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput() != null) {
            if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().isゆうちょ銀行()) {
                div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShu().setLabelLText(預金種目);
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().setDisplayNone(false);
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().setDisplayNone(false);
            } else {
                div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShu().setLabelLText(預金種別);
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenBan().setDisplayNone(true);
                div.getChosaitakusakiJohoInput().getKozaJoho().getTxtTenMei().setDisplayNone(true);
            }
        }
    }

    public RString getShitenMeisho(RString shitenCode) {
        RString 支店名 = new RString("");
        if (div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関() == null) {
            return 支店名;
        }
        List<KinyuKikanShiten> kinyuKikanShitenlist = div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().get金融機関().get支店リスト();
        for (KinyuKikanShiten shiten : kinyuKikanShitenlist) {
            if (new RString(shiten.get支店コード().toString()).equals(shitenCode)) {
                支店名 = shiten.get支店名称();
            }
        }
        return 支店名;
    }

    /**
     * 金融機関を取得します。
     *
     * @param 金融機関情報 List<KinyuKikan>
     * @param row dgSonotaKikanIchiran_Row
     * @return 金融機関_支店　RString
     */
    private RString getKinyuKikan(List<KinyuKikan> 金融機関情報, dgSonotaKikanIchiran_Row row) {
        RString 金融機関 = RString.EMPTY;
        for (KinyuKikan kinyuKikanJoho : 金融機関情報) {
            if ((new RString(kinyuKikanJoho.get金融機関コード().toString())).equals(row.getKinyuKikanCode())) {
                金融機関 = kinyuKikanJoho.get金融機関名称();
            }
        }
        return 金融機関;
    }

    /**
     * 金融機関支店を取得します。
     *
     * @param 金融機関情報 List<KinyuKikan>
     * @param row dgSonotaKikanIchiran_Row
     * @return 支店名　RString
     */
    private RString getKinyuShiten(List<KinyuKikan> 金融機関情報, dgSonotaKikanIchiran_Row row) {
        List<KinyuKikanShiten> 支店リスト = new ArrayList<>();
        RString 支店名 = RString.EMPTY;
        for (KinyuKikan kinyuKikanJoho : 金融機関情報) {
            if ((new RString(kinyuKikanJoho.get金融機関コード().toString())).equals(row.getKinyuKikanCode())) {
                支店リスト = kinyuKikanJoho.get支店リスト();
            }
        }
        if (支店リスト != null && !支店リスト.isEmpty()) {
            支店名 = getShitenMeisho(支店リスト, row, 支店名);

        }

        return 支店名;
    }

    private RString getShitenMeisho(List<KinyuKikanShiten> 支店リスト, dgSonotaKikanIchiran_Row row, RString 支店名) {
        for (KinyuKikanShiten shiten : 支店リスト) {
            if (new RString(shiten.get支店コード().toString()).equals(row.getKinyuKikanShitenCode())) {
                支店名 = shiten.get支店名称();
            }
        }
        return 支店名;
    }

    private RString get預金種名(List<KinyuKikan> 金融機関情報, RString kinyuKikanCode, RString yokinShu) {
        RString 預金種名 = new RString("");
        for (KinyuKikan kinyuKikanJoho : 金融機関情報) {
            if ((new RString(kinyuKikanJoho.get金融機関コード().toString())).equals(kinyuKikanCode)) {
                預金種名 = kinyuKikanJoho.get預金種別(yokinShu).get預金種別名称();
            }
        }
        return 預金種名;
    }
}
