/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.IryohiKojo;
import jp.co.ndensan.reams.db.dbd.business.core.basic.IryohiKojoBuilder;
import jp.co.ndensan.reams.db.dbd.definition.core.iryohikojo.IryoHiKojoNaiyo;
import jp.co.ndensan.reams.db.dbd.definition.core.iryohikojo.NichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001.IryohiKojyoItiranDataGrid_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001.IryouhiKoujyoDiv;
import jp.co.ndensan.reams.db.dbd.service.core.basic.IryohiKojoManager;
import jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei.IryoHiKojoKakuninSinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 医療費控除登録画面のHandlerです。
 *
 * @reamsid_L DBD-5770-010 tz_chengpeng
 */
public class IryouhiKoujyoHandler {

    private final IryouhiKoujyoDiv div;
    private static final RString 医療費控除登録 = new RString("IryohiKojyoToroku");
    private static final RString DB = new RString("DB");
    private static final RString 有 = new RString("有");
    private static final RString キー0 = new RString("0");
    private static final RString キー1 = new RString("1");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final int INT_3 = 3;

    /**
     * コンストラクタです。
     *
     * @param div IryouhiKoujyoDiv
     */
    public IryouhiKoujyoHandler(IryouhiKoujyoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化
     *
     * @param 引き継ぎEntity 引き継ぎEntity
     * @return List<IryohiKojoEntity>
     */
    public List<IryohiKojo> onLoad(TaishoshaKey 引き継ぎEntity) {

        HihokenshaNo 被保険者番号 = 引き継ぎEntity.get被保険者番号();
        IryoHiKojoKakuninSinsei iryoHiKojoKakuninSinsei = IryoHiKojoKakuninSinsei.createIntance();
        if (!iryoHiKojoKakuninSinsei.checkuJukyusha(被保険者番号)) {
            throw new ApplicationException(DbdErrorMessages.受給共通_受給者登録なし.getMessage());
        }
        List<IryohiKojo> 医療費控除リスト = iryoHiKojoKakuninSinsei.getIryohikojyo(被保険者番号);
        div.getIryohiKojyoToroku().getKaigoAtenaInfoChildDiv().initialize(引き継ぎEntity.get識別コード());
        div.getIryohiKojyoToroku().getKaigoShikakuKihonChildDiv().initialize(引き継ぎEntity.get被保険者番号());
        initGrid(医療費控除リスト);

        RealInitialLocker.lock(new LockingKey(DB.concat(被保険者番号.value()).concat(医療費控除登録)));
        AccessLogger.log(AccessLogType.照会, PersonalData.of(引き継ぎEntity.get識別コード(),
                ExpandedInformation.newBuilder().code(new Code("003")).name(new RString("被保険者番号")).value(被保険者番号).build()));
        return 医療費控除リスト;
    }

    /**
     * 詳細エリア初期化
     */
    public void init詳細データ() {

        RString データ区分 = div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().getSelectedKey();
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getSinseYYMMDD().clearValue();
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTorokuYYMMDD().clearValue();
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().clearValue();

        if (IryoHiKojoNaiyo.主治医意見書確認書.getコード().equals(データ区分)) {
            div.getIryohiKojyoSyosai().getSyosaiPanel2().getSakuseYYMMDD().clearValue();
            div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteFromYYMMDD().clearValue();
            div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteEndYYMMDD().clearValue();
            div.getIryohiKojyoSyosai().getSyosaiPanel2().getNitijyoSekatuJiritudo().setSelectedKey(NichijoSeikatsuJiritsudo.その他.getコード());
            div.getIryohiKojyoSyosai().getSyosaiPanel2().getNyosikin().setSelectedKey(キー1);
        }
    }

    /**
     * 詳細エリアパネル1データ設定
     */
    public void set詳細データパネル1() {
        IryohiKojyoItiranDataGrid_Row row = div.getIryohiKojyoItiran().getIryohiKojyoItiranDataGrid().getActiveRow();
        RString データ区分 = row.getHiddenCodeKubun();
        RDate 申請日 = row.getHiddensinseiDD().getValue();
        RDate 登録日 = row.getHiddentorokuDD().getValue();
        RDate 対象年 = row.getHiddentaisyouYY().getValue();

        div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().setSelectedKey(データ区分);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getSinseYYMMDD().setValue(申請日);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTorokuYYMMDD().setValue(登録日);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().setValue(対象年);
    }

    /**
     * 詳細エリアデータ設定
     */
    public void set詳細データ() {
        IryohiKojyoItiranDataGrid_Row row = div.getIryohiKojyoItiran().getIryohiKojyoItiranDataGrid().getActiveRow();
        RString データ区分 = row.getHiddenCodeKubun();
        RDate 申請日 = row.getHiddensinseiDD().getValue();
        RDate 登録日 = row.getHiddentorokuDD().getValue();
        RDate 対象年 = row.getHiddentaisyouYY().getValue();
        RDate 主治医意見書作成日 = row.getHiddenikensyoSakuseDD().getValue();
        RDate 認定期間_開始日 = row.getHiddenninteFromDD().getValue();
        RDate 認定期間_終了日 = row.getHiddenninteEndDD().getValue();
        RString 日常生活自立度 = row.getHiddennitijyoSekatuJiritudoCode();
        RString 尿失禁の有無 = row.getNyosikinFlg().isNullOrEmpty() ? キー1 : キー0;

        div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().setSelectedKey(データ区分);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getSinseYYMMDD().setValue(申請日);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTorokuYYMMDD().setValue(登録日);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().setValue(対象年);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getSakuseYYMMDD().setValue(主治医意見書作成日);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteFromYYMMDD().setValue(認定期間_開始日);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteEndYYMMDD().setValue(認定期間_終了日);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNitijyoSekatuJiritudo().setSelectedKey(
                日常生活自立度.isNullOrEmpty() ? NichijoSeikatsuJiritsudo.その他.getコード() : 日常生活自立度);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNyosikin().setSelectedKey(尿失禁の有無);
    }

    /**
     * 医療費控除詳細エリアの各項目を初期化する
     */
    public void init詳細エリア() {
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getSinseYYMMDD().clearValue();
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTorokuYYMMDD().clearValue();
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().clearValue();
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getSakuseYYMMDD().clearValue();
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteFromYYMMDD().clearValue();
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteEndYYMMDD().clearValue();
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNitijyoSekatuJiritudo().setSelectedKey(NichijoSeikatsuJiritsudo.その他.getコード());
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNyosikin().setSelectedKey(キー1);

        div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().setReadOnly(false);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getSinseYYMMDD().setReadOnly(false);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTorokuYYMMDD().setReadOnly(false);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().setReadOnly(false);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getSakuseYYMMDD().setReadOnly(false);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteFromYYMMDD().setReadOnly(false);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteEndYYMMDD().setReadOnly(false);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNitijyoSekatuJiritudo().setReadOnly(false);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNyosikin().setReadOnly(false);
    }

    /**
     * 確定操作
     *
     * @param 被保険者番号 被保険者番号
     * @param 状態 状態
     * @param 医療費控除リスト 医療費控除リスト
     */
    public void onClick_KakuteButton(HihokenshaNo 被保険者番号, RString 状態, List<IryohiKojo> 医療費控除リスト) {
        List<IryohiKojyoItiranDataGrid_Row> dataSource = div.getIryohiKojyoItiran().getIryohiKojyoItiranDataGrid().getDataSource();
        if (状態.equals(追加)) {
            IryohiKojyoItiranDataGrid_Row row = new IryohiKojyoItiranDataGrid_Row();
            setGridRow(row);
            row.setJyoutai(状態);
            dataSource.add(row);
            removeEmptyRow(dataSource);
            Collections.sort(dataSource, new Comparator<IryohiKojyoItiranDataGrid_Row>() {
                @Override
                public int compare(IryohiKojyoItiranDataGrid_Row row1, IryohiKojyoItiranDataGrid_Row row2) {
                    if (row2.getHiddentaisyouYY().getValue().compareTo(row1.getHiddentaisyouYY().getValue()) == 0) {
                        return row2.getHiddenCodeKubun().compareTo(row1.getHiddenCodeKubun());
                    }
                    return row2.getHiddentaisyouYY().getValue().compareTo(row1.getHiddentaisyouYY().getValue());
                }
            });
        } else if (状態.equals(修正)) {
            IryohiKojyoItiranDataGrid_Row row = dataSource.get(div.getIryohiKojyoItiran().getIryohiKojyoItiranDataGrid().getActiveRowId());
            setGridRow(row);
            IryohiKojo 医療費控除 = getIryohiKojo(被保険者番号,
                    new FlexibleYear(row.getHiddentaisyouYY().getValue().getYear().toDateString()),
                    row.getHiddenCodeKubun(), 医療費控除リスト);
            IryohiKojoBuilder builder = 医療費控除.createBuilderForEdit();
            builder.set登録年月日(new FlexibleDate(row.getHiddentorokuDD().getValue().toDateString()));
            builder.set申請年月日(new FlexibleDate(row.getHiddensinseiDD().getValue().toDateString()));
            set医療費控除画面項目(builder, row);
            if (!row.getJyoutai().equals(追加) && builder.build().hasChanged()) {
                row.setJyoutai(状態);
            } else if (!row.getJyoutai().equals(追加) && !builder.build().hasChanged()) {
                row.setJyoutai(RString.EMPTY);
            }
        } else if (状態.equals(削除)) {
            IryohiKojyoItiranDataGrid_Row row = dataSource.get(div.getIryohiKojyoItiran().getIryohiKojyoItiranDataGrid().getActiveRowId());
            if (!row.getJyoutai().equals(追加)) {
                row.setJyoutai(状態);
            } else {
                dataSource.remove(row);
                addEmptyRow(dataSource);
            }
        }
        div.getIryohiKojyoItiran().getIryohiKojyoItiranDataGrid().setDataSource(dataSource);
        init詳細エリア();
        div.getIryohiKojyoSyosai().setIsOpen(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
    }

    /**
     * 確定確認チェック
     *
     * @return boolean
     */
    public boolean 確定確認チェック() {
        if (div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().getSelectedKey()
                .equals(IryoHiKojoNaiyo.主治医意見書確認書.getコード())) {
            return div.getIryohiKojyoSyosai().getSyosaiPanel2().getSakuseYYMMDD().getValue() == null
                    || div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteFromYYMMDD().getValue() == null
                    || (div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteFromYYMMDD().getValue() != null
                    && div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteEndYYMMDD().getValue() == null)
                    || div.getIryohiKojyoSyosai().getSyosaiPanel2().getNitijyoSekatuJiritudo().getSelectedKey()
                    .equals(NichijoSeikatsuJiritsudo.その他.getコード())
                    || div.getIryohiKojyoSyosai().getSyosaiPanel2().getNyosikin().getSelectedKey().equals(キー1);
        }
        return false;
    }

    /**
     * 「保存する」ボタンonClick
     *
     * @param 引き継ぎEntity 引き継ぎEntity
     * @param 医療費控除リスト 医療費控除リスト
     */
    public void save(TaishoshaKey 引き継ぎEntity, List<IryohiKojo> 医療費控除リスト) {
        HihokenshaNo 被保険者番号 = 引き継ぎEntity.get被保険者番号();
        IryohiKojoManager manager = new IryohiKojoManager();
        for (IryohiKojyoItiranDataGrid_Row row : div.getIryohiKojyoItiran().getIryohiKojyoItiranDataGrid().getDataSource()) {
            if (追加.equals(row.getJyoutai())) {
                FlexibleYear 控除対象年 = new FlexibleYear(row.getHiddentaisyouYY().getValue().getYear().toDateString());
                IryohiKojo 医療費控除 = new IryohiKojo(被保険者番号, 控除対象年, row.getHiddenCodeKubun());
                IryohiKojoBuilder builder = 医療費控除.createBuilderForEdit();
                builder.set登録年月日(row.getHiddentorokuDD().getValue() == null ? FlexibleDate.EMPTY
                        : new FlexibleDate(row.getHiddentorokuDD().getValue().toDateString()));
                builder.set申請年月日(row.getHiddensinseiDD().getValue() == null ? FlexibleDate.EMPTY
                        : new FlexibleDate(row.getHiddensinseiDD().getValue().toDateString()));
                builder.set発行年月日(FlexibleDate.EMPTY);
                builder.set論理削除フラグ(false);
                set医療費控除画面項目(builder, row);
                manager.save医療費控除(builder.build().added());
            } else if (修正.equals(row.getJyoutai())) {
                FlexibleYear 控除対象年 = new FlexibleYear(row.getHiddentaisyouYY().getValue().getYear().toDateString());
                IryohiKojo 医療費控除 = getIryohiKojo(被保険者番号, 控除対象年, row.getHiddenCodeKubun(), 医療費控除リスト);
                IryohiKojoBuilder builder = 医療費控除.createBuilderForEdit();
                builder.set登録年月日(new FlexibleDate(row.getHiddentorokuDD().getValue().toDateString()));
                builder.set申請年月日(new FlexibleDate(row.getHiddensinseiDD().getValue().toDateString()));
                set医療費控除画面項目(builder, row);
                manager.save医療費控除(builder.build().modifiedModel());
            } else if (削除.equals(row.getJyoutai())) {
                FlexibleYear 控除対象年 = new FlexibleYear(row.getHiddentaisyouYY().getValue().getYear().toDateString());
                IryohiKojo 医療費控除 = getIryohiKojo(被保険者番号, 控除対象年, row.getHiddenCodeKubun(), 医療費控除リスト);
                IryohiKojoBuilder builder = 医療費控除.createBuilderForEdit();
                manager.delete医療費控除(builder.build().deleted());
            }
        }
        AccessLogger.log(AccessLogType.更新, PersonalData.of(引き継ぎEntity.get識別コード(),
                ExpandedInformation.newBuilder().code(new Code("003")).name(new RString("被保険者番号")).value(被保険者番号).build()));
        RealInitialLocker.release(new LockingKey(DB.concat(被保険者番号.value()).concat(医療費控除登録)));
    }

    /**
     * 「クリアする」ボタンクリックイベント。
     *
     * @param 医療費控除リスト 医療費控除リスト
     */
    public void onClick_ClearButton(List<IryohiKojo> 医療費控除リスト) {
        initGrid(医療費控除リスト);
        init詳細エリア();
    }

    private void initGrid(List<IryohiKojo> 医療費控除リスト) {
        List<IryohiKojyoItiranDataGrid_Row> dataSource = new ArrayList<>();
        if (医療費控除リスト != null && !医療費控除リスト.isEmpty()) {
            for (IryohiKojo entity : 医療費控除リスト) {
                IryohiKojyoItiranDataGrid_Row row = new IryohiKojyoItiranDataGrid_Row();
                row.setNaiyou(IryoHiKojoNaiyo.toValue(entity.getデータ区分()).get名称());
                RYear 控除対象年 = new RYear(entity.get控除対象年().toDateString());
                row.setTaisyouYY(控除対象年.wareki().toDateString());
                row.setTorokuDD(entity.get登録年月日().wareki().toDateString());
                row.setSinseiDD(entity.get申請年月日().wareki().toDateString());
                row.setHakouDD(entity.get発行年月日().wareki().toDateString());
                row.setNinteFromDD(entity.get認定有効期間開始年月日().wareki().toDateString());
                row.setNinteEndDD(entity.get認定有効期間終了年月日().wareki().toDateString());
                row.setIkensyoSakuseDD(entity.get主治医意見書受領年月日().wareki().toDateString());
                row.setNitijyoSekatuJiritudo(entity.get日常生活自立度().isNullOrEmpty() || entity.get日常生活自立度().equals(NichijoSeikatsuJiritsudo.その他.getコード())
                        ? RString.EMPTY : NichijoSeikatsuJiritsudo.toValue(entity.get日常生活自立度()).get名称());
                row.setNyosikinFlg(entity.is尿失禁の有無() ? 有 : RString.EMPTY);
                row.setHiddenCodeKubun(entity.getデータ区分());
                row.setHiddennitijyoSekatuJiritudoCode(entity.get日常生活自立度());
                row.setHiddennyosikinFlg(entity.is尿失禁の有無() ? キー0 : キー1);
                row.getHiddentaisyouYY().setValue(new RDate(控除対象年.getYearValue()));
                row.getHiddentorokuDD().setValue(entity.get登録年月日().isEmpty() || entity.get登録年月日() == null ? null
                        : new RDate(entity.get登録年月日().toString()));
                row.getHiddensinseiDD().setValue(entity.get申請年月日().isEmpty() || entity.get申請年月日() == null ? null
                        : new RDate(entity.get申請年月日().toString()));
                row.getHiddenninteFromDD().setValue(entity.get認定有効期間開始年月日().isEmpty() || entity.get認定有効期間開始年月日() == null ? null
                        : new RDate(entity.get認定有効期間開始年月日().toString()));
                row.getHiddenninteEndDD().setValue(entity.get認定有効期間終了年月日().isEmpty() || entity.get認定有効期間終了年月日() == null ? null
                        : new RDate(entity.get認定有効期間終了年月日().toString()));
                row.getHiddenikensyoSakuseDD().setValue(entity.get主治医意見書受領年月日().isEmpty() || entity.get主治医意見書受領年月日() == null ? null
                        : new RDate(entity.get主治医意見書受領年月日().toString()));
                dataSource.add(row);
            }
        }
        addEmptyRow(dataSource);
        div.getIryohiKojyoItiran().getIryohiKojyoItiranDataGrid().setDataSource(dataSource);
    }

    private void setGridRow(IryohiKojyoItiranDataGrid_Row row) {
        RString データ区分 = div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().getSelectedKey();
        RDate 申請日 = div.getIryohiKojyoSyosai().getSyosaiPanel1().getSinseYYMMDD().getValue();
        RDate 登録日 = div.getIryohiKojyoSyosai().getSyosaiPanel1().getTorokuYYMMDD().getValue();
        RDate 対象年 = div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().getValue();
        row.setNaiyou(IryoHiKojoNaiyo.toValue(データ区分).get名称());
        row.setHiddenCodeKubun(データ区分);
        row.setSinseiDD(申請日.wareki().toDateString());
        row.getHiddensinseiDD().setValue(申請日);
        row.setTorokuDD(登録日.wareki().toDateString());
        row.getHiddentorokuDD().setValue(登録日);
        row.setTaisyouYY(対象年.getYear().wareki().toDateString());
        row.getHiddentaisyouYY().setValue(対象年);

        if (データ区分.equals(IryoHiKojoNaiyo.主治医意見書確認書.getコード())) {
            RDate 主治医意見書作成日 = div.getIryohiKojyoSyosai().getSyosaiPanel2().getSakuseYYMMDD().getValue();
            RDate 認定期間_開始日 = div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteFromYYMMDD().getValue();
            RDate 認定期間_終了日 = div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteEndYYMMDD().getValue();
            RString 日常生活自立度 = div.getIryohiKojyoSyosai().getSyosaiPanel2().getNitijyoSekatuJiritudo().getSelectedKey();
            RString 尿失禁の有無 = div.getIryohiKojyoSyosai().getSyosaiPanel2().getNyosikin().getSelectedKey();
            row.setIkensyoSakuseDD(主治医意見書作成日 != null ? 主治医意見書作成日.wareki().toDateString() : RString.EMPTY);
            row.getHiddenikensyoSakuseDD().setValue(主治医意見書作成日);
            row.setNinteFromDD(認定期間_開始日 != null ? 認定期間_開始日.wareki().toDateString() : RString.EMPTY);
            row.getHiddenninteFromDD().setValue(認定期間_開始日);
            row.setNinteEndDD(認定期間_終了日 != null ? 認定期間_終了日.wareki().toDateString() : RString.EMPTY);
            row.getHiddenninteEndDD().setValue(認定期間_終了日);
            row.setNitijyoSekatuJiritudo(日常生活自立度.equals(NichijoSeikatsuJiritsudo.その他.getコード())
                    ? RString.EMPTY : NichijoSeikatsuJiritsudo.toValue(日常生活自立度).get名称());
            row.setHiddennitijyoSekatuJiritudoCode(日常生活自立度);
            row.setHiddennyosikinFlg(尿失禁の有無);
            row.setNyosikinFlg(尿失禁の有無.equals(キー0) ? 有 : RString.EMPTY);
        }
    }

    private void set医療費控除画面項目(IryohiKojoBuilder builder, IryohiKojyoItiranDataGrid_Row row) {
        if (IryoHiKojoNaiyo.おむつ使用証明書.getコード().equals(row.getHiddenCodeKubun())) {
            builder.set認定有効期間開始年月日(FlexibleDate.EMPTY);
            builder.set認定有効期間終了年月日(FlexibleDate.EMPTY);
            builder.set主治医意見書受領年月日(FlexibleDate.EMPTY);
            builder.set日常生活自立度(RString.EMPTY);
            builder.set尿失禁の発生(false);
        } else {
            builder.set認定有効期間開始年月日(row.getHiddenninteFromDD().getValue() != null
                    ? new FlexibleDate(row.getHiddenninteFromDD().getValue().toDateString()) : FlexibleDate.EMPTY);
            builder.set認定有効期間終了年月日(row.getHiddenninteEndDD().getValue() != null
                    ? new FlexibleDate(row.getHiddenninteEndDD().getValue().toDateString()) : FlexibleDate.EMPTY);
            builder.set主治医意見書受領年月日(row.getHiddenikensyoSakuseDD().getValue() != null
                    ? new FlexibleDate(row.getHiddenikensyoSakuseDD().getValue().toDateString()) : FlexibleDate.EMPTY);
            builder.set日常生活自立度(row.getHiddennitijyoSekatuJiritudoCode());
            builder.set尿失禁の発生(row.getHiddennyosikinFlg().equals(キー0));
        }
    }

    private IryohiKojo getIryohiKojo(HihokenshaNo 被保険者番号, FlexibleYear 控除対象年, RString データ区分, List<IryohiKojo> 医療費控除リスト) {
        for (IryohiKojo 医療費控除 : 医療費控除リスト) {
            if (医療費控除.get被保険者番号().equals(被保険者番号)
                    && 医療費控除.get控除対象年().equals(控除対象年)
                    && 医療費控除.getデータ区分().equals(データ区分)) {
                return 医療費控除;
            }
        }
        return new IryohiKojo(被保険者番号, 控除対象年, データ区分);
    }

    private void addEmptyRow(List<IryohiKojyoItiranDataGrid_Row> dataSource) {
        int size = INT_3 - dataSource.size();
        for (int i = 1; i <= size; i++) {
            dataSource.add(new IryohiKojyoItiranDataGrid_Row());
        }
    }

    private void removeEmptyRow(List<IryohiKojyoItiranDataGrid_Row> dataSource) {
        for (IryohiKojyoItiranDataGrid_Row row : dataSource) {
            if (row.getHiddensinseiDD().getValue() == null) {
                dataSource.remove(row);
                return;
            }
        }
    }
}
