/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenkohaakuichiran;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010.ShiharaiHohoHenkoHaakuMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010.ShiharaiHohoHenkoKanriMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoKanriResultEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran.IShiharaiHohoHenkoHaakuMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran.IShiharaiHohoHenkoKanriMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBDMN32001_2_支払方法変更滞納者把握リスト作成（バッチ）
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
public class ShiharaiHohoHenkoHaakuIchiran {

    private final MapperProvider mapperProvider;
    private ShiharaiHohoHenkoHaakuEntity shiharaiHohoHenkoHaakuEntity;
    private ShiharaiHohoHenkoKanriResultEntity shiharaiHohoHenkoKanriEntity;

    /**
     * コンストラクタです。
     */
    ShiharaiHohoHenkoHaakuIchiran() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです
     *
     * @param shiharaiHohoHenkoHaakuEntity 支払方法変更把握リストEntity
     */
    ShiharaiHohoHenkoHaakuIchiran(ShiharaiHohoHenkoHaakuEntity shiharaiHohoHenkoHaakuEntity) {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.shiharaiHohoHenkoHaakuEntity = shiharaiHohoHenkoHaakuEntity;
    }

    /**
     * コンストラクタです
     *
     * @param shiharaiHohoHenkoKanriEntity 支払方法変更管理リストEntity
     */
    ShiharaiHohoHenkoHaakuIchiran(ShiharaiHohoHenkoKanriResultEntity shiharaiHohoHenkoKanriEntity) {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.shiharaiHohoHenkoKanriEntity = shiharaiHohoHenkoKanriEntity;
    }

    public void printShiharaiHohoHenkoKanriList() {
        if (shiharaiHohoHenkoKanriEntity != null) {
            // get出力順(shiharaiHohoHenkoKanriEntity.get改頁出力順ID(), shiharaiHohoHenkoKanriEntity.get帳票ID());
        }

        if (shiharaiHohoHenkoHaakuEntity != null) {
            get出力順(shiharaiHohoHenkoHaakuEntity.get改頁出力順ID(), shiharaiHohoHenkoHaakuEntity.get帳票ID());
        }
    }

    /**
     * 出力順を取得します
     *
     * @param 出力順ID 出力順ID
     * @param 帳票ID 帳票ID
     * @return 出力順
     */
    private RString get出力順(Long 出力順ID, ReportId 帳票ID) {
        // UrControlDataFactory.createInstance().getLoginInfo.().getUserId(); TODO
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給, 帳票ID, RString.EMPTY, 出力順ID);
//TODO
        return MyBatisOrderByClauseCreator.create(null, outputOrder);
    }

    private void get市町村コードと市町村名() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        association.get地方公共団体コード();
        association.get市町村名();
    }

    private void get支払方法変更管理抽出対象() {

    }

    private void get支払方法変更滞納者把握抽出対象() {

    }

    public void selectShiharaiHohoHenkoKanri(FlexibleDate 基準日) {

    }

    /**
     * 支払方法変更滞納者を抽出する
     *
     * @param 基準日 基準日
     * @param 被保険者選択 被保険者選択
     * @param 被保険者全員の滞納期間 被保険者全員の滞納期間
     * @param 受給者全員 受給者全員
     * @param 受給者全員の滞納期間 受給者全員の滞納期間
     * @param 受給認定申請中者 受給認定申請中者
     * @param 受給認定申請中者の滞納期間 受給認定申請中者の滞納期間
     * @param 受給認定日抽出 受給認定日抽出
     * @param 受給認定日抽出の滞納期間 受給認定日抽出の滞納期間
     * @param 受給認定日抽出の開始 受給認定日抽出の開始
     * @param 受給認定日抽出の終了 受給認定日抽出の終了
     * @param 受給申請中者 受給申請中者
     * @param 受給申請中者の滞納期間 受給申請中者の滞納期間
     * @param 受給支給決定日抽出 受給支給決定日抽出
     * @param 受給支給決定日抽出の滞納期間 受給支給決定日抽出の滞納期間
     * @param 受給支給決定日抽出の開始 受給支給決定日抽出の開始
     * @param 受給支給決定日抽出の終了 受給支給決定日抽出の終了
     * @param 出力順 出力順
     */
    public void selectTainosha(FlexibleDate 基準日,
            Long 被保険者選択,
            Long 被保険者全員の滞納期間,
            Long 受給者全員,
            Long 受給者全員の滞納期間,
            Long 受給認定申請中者,
            Long 受給認定申請中者の滞納期間,
            Long 受給認定日抽出,
            Long 受給認定日抽出の滞納期間,
            FlexibleDate 受給認定日抽出の開始,
            FlexibleDate 受給認定日抽出の終了,
            Long 受給申請中者,
            Long 受給申請中者の滞納期間,
            Long 受給支給決定日抽出,
            Long 受給支給決定日抽出の滞納期間,
            FlexibleDate 受給支給決定日抽出の開始,
            FlexibleDate 受給支給決定日抽出の終了,
            RString 出力順) {

        ShiharaiHohoHenkoHaakuMybatisParameter parameter = new ShiharaiHohoHenkoHaakuMybatisParameter(基準日,
                被保険者選択,
                被保険者全員の滞納期間,
                受給者全員,
                受給者全員の滞納期間,
                受給認定申請中者,
                受給認定申請中者の滞納期間,
                受給認定日抽出,
                受給認定日抽出の滞納期間,
                受給認定日抽出の開始,
                受給認定日抽出の終了,
                受給申請中者,
                受給申請中者の滞納期間,
                受給支給決定日抽出,
                受給支給決定日抽出の滞納期間,
                受給支給決定日抽出の開始,
                受給支給決定日抽出の終了,
                出力順);
        IShiharaiHohoHenkoHaakuMapper mapper = mapperProvider.create(IShiharaiHohoHenkoHaakuMapper.class);
        mapper.find支払方法変更滞納者情報(parameter);
    }

    /**
     * 支払方法変更管理対象者を抽出する
     *
     * @param 基準日 基準日
     * @param 登録者選択 登録者選択
     * @param 差止予告登録者２号の選択 差止予告登録者２号の選択
     * @param 差止登録者２号の選択 差止登録者２号の選択
     * @param 償還予告登録者１号の選択 償還予告登録者１号の選択
     * @param 償還決定登録者１号の選択 償還決定登録者１号の選択
     * @param 償還決定登録者１号_差止中あり者のみの選択 償還決定登録者１号_差止中あり者のみの選択
     * @param 償還決定登録者１号_保険料控除あり者のみの選択 償還決定登録者１号_保険料控除あり者のみの選択
     * @param 出力順 出力順
     */
    public void selectTaishosha(FlexibleDate 基準日,
            Long 登録者選択,
            Long 差止予告登録者２号の選択,
            Long 差止登録者２号の選択,
            Long 償還予告登録者１号の選択,
            Long 償還決定登録者１号の選択,
            Long 償還決定登録者１号_差止中あり者のみの選択,
            Long 償還決定登録者１号_保険料控除あり者のみの選択,
            RString 出力順) {

        ShiharaiHohoHenkoKanriMybatisParameter parameter = new ShiharaiHohoHenkoKanriMybatisParameter(基準日,
                登録者選択,
                差止予告登録者２号の選択,
                差止登録者２号の選択,
                償還予告登録者１号の選択,
                償還決定登録者１号の選択,
                償還決定登録者１号_差止中あり者のみの選択,
                償還決定登録者１号_保険料控除あり者のみの選択,
                出力順);

        IShiharaiHohoHenkoKanriMapper mapper = mapperProvider.create(IShiharaiHohoHenkoKanriMapper.class);
        mapper.get支払方法変更管理対象者(parameter);
    }
}
