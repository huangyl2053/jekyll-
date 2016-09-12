/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.createtarget;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.createtarget.CreateTargetMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.createtarget.CreateTargetCsvRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.createtarget.CreateTargetRelateEntity;

/**
 * センター送信データ出力のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
public interface ICreateTargetMapper {

    /**
     * 対象者一覧情報を検索します。
     *
     * @param param センター送信データ
     * @return List<CreateTargetRelateEntity>
     */
    List<CreateTargetRelateEntity> getTaishouJouhou(CreateTargetMapperParameter param);

    /**
     * CSVファイル出力用データの抽出します。
     *
     * @param param センター送信データ
     * @return List<CreateTargetCsvRelateEntity>
     */
    List<CreateTargetCsvRelateEntity> getCsvData(CreateTargetMapperParameter param);

    /**
     * 主治医意見書意見項目を検索します。
     *
     * @param param センター送信データ
     * @return List<CreateTargetRelateEntity>
     */
    List<CreateTargetRelateEntity> get主治医意見書意見項目(CreateTargetMapperParameter param);

    /**
     * サービスの状況を検索します。
     *
     * @param param センター送信データ
     * @return List<CreateTargetRelateEntity>
     */
    List<CreateTargetRelateEntity> getサービスの状況(CreateTargetMapperParameter param);

    /**
     * 調査票調査項目を検索します。
     *
     * @param param センター送信データ
     * @return List<CreateTargetRelateEntity>
     */
    List<CreateTargetRelateEntity> get調査票調査項目(CreateTargetMapperParameter param);

    /**
     * 前回調査票調査項目を検索します。
     *
     * @param param センター送信データ
     * @return List<CreateTargetRelateEntity>
     */
    List<CreateTargetRelateEntity> get前回調査票調査項目(CreateTargetMapperParameter param);

    /**
     * 前回サービスの状況を検索します。
     *
     * @param param センター送信データ
     * @return List<CreateTargetRelateEntity>
     */
    List<CreateTargetRelateEntity> get前回サービスの状況(CreateTargetMapperParameter param);
}
